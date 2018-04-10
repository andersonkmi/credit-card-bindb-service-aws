package org.sharpsw.sakura.service

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.model.{AttributeValue, GetItemRequest}
import org.sharpsw.sakura.BinDBResponse

import scala.collection.JavaConverters._
import scala.util.Properties

object DynamoDBService {
  private val dynamoDbService = AmazonDynamoDBClientBuilder.standard.build

  def findRecord(bin: String): BinDBResponse = {
    val key = Map(
      "bin" -> new AttributeValue().withS(bin)
    ).asJava

    val request = new GetItemRequest().withTableName(Properties.envOrElse(AWSLambdaEnvVars.BinDbDynamoTable, AWSLambdaEnvVars.BinDbDynamoTableDefault)).withKey(key)
    val result = dynamoDbService.getItem(request)
    val items = Option(result.getItem)

    items match {
      case Some(items) => {
        val binNumber       = items.get("bin").getS
        val bank            = items.get("bank").getS
        val brand           = items.get("brand").getS
        val cardType        = items.get("cardType").getS
        val countryCode     = items.get("countryCode").getS
        val isoCountryCode  = items.get("isoCountryCode").getS
        val level           = items.get("level").getS
        val response = new BinDBResponse()
        response.setBin(binNumber)
        response.setBank(bank)
        response.setBrand(brand)
        response.setCardType(cardType)
        response.setCountryCode(countryCode)
        response.setIsoCountry(isoCountryCode)
        response.setLevel(level)
        response
      }
      case _ => val response = new BinDBResponse()
        response.setBin("00000")
        response.setBank("")
        response.setBrand("")
        response.setCardType("")
        response.setCountryCode("")
        response.setIsoCountry("")
        response.setLevel("")
        response

    }

  }
}
