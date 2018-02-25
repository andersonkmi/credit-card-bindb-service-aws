package org.sharpsw.dataproc.aws

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import org.sharpsw.dataproc.AWSLambdaEnvVars.{BinDbDynamoTable, BinDbDynamoTableDefault}
import org.sharpsw.dataproc.data.BinRecord

import scala.collection.JavaConverters._
import scala.util.Properties

object DynamoDB {
  private val dynamoService = AmazonDynamoDBClientBuilder.standard.build

  private val BinField: String = "bin"
  private val BrandField: String = "brand"
  private val BankField: String = "bank"
  private val CardTypeField: String = "cardType"
  private val LevelField: String = "level"
  private val IsoCountryField: String = "isoCountry"
  private val CountryCodeField: String = "countryCode"

  def putRecord(record: BinRecord): Boolean = {
    val values = Map(
      BinField -> new AttributeValue().withS(record.bin),
      BrandField -> new AttributeValue().withS(record.brand),
      BankField -> new AttributeValue().withS(record.bank),
      CardTypeField -> new AttributeValue().withS(record.cardType),
      LevelField -> new AttributeValue().withS(record.level),
      IsoCountryField -> new AttributeValue().withS(record.isoCountry),
      CountryCodeField -> new AttributeValue().withS(record.countryCode)
    ).asJava

    try {
      dynamoService.putItem(Properties.envOrElse(BinDbDynamoTable, BinDbDynamoTableDefault), values)
      true
    } catch {
      case exception: Exception => {
        println(exception.getMessage)
        false
      }
    }
  }
}
