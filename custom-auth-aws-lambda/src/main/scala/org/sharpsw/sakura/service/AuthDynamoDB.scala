package org.sharpsw.sakura.service
import com.amazonaws.services.dynamodbv2.model.{AttributeValue, GetItemRequest, GetItemResult}
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.sharpsw.sakura.service.AWSLambdaEnvVars.{AuthenticationDynamoDBTable, AuthenticationDynamoDBTableDefault}

import scala.collection.JavaConverters._
import scala.util.Properties

object AuthDynamoDB {
  private val AuthKeyColumn = "authenticationKey"
  private val EnabledColumn = "enabled"
  private val PrincipalIdColumn = "principalId"


  private def getCredentials(authKey: String): GetItemResult = {
    val client = AmazonDynamoDBClientBuilder.standard().build()
    val key = Map(
      AuthKeyColumn -> new AttributeValue().withS(authKey)
    ).asJava

    val request = new GetItemRequest().withTableName(Properties.envOrElse(AuthenticationDynamoDBTable, AuthenticationDynamoDBTableDefault)).withKey(key)
    client.getItem(request)
  }

  def isAuthorized(authKey: String): (String, Boolean) = {
    try {
      val result = getCredentials(authKey)
      val items = Option(result.getItem)

      items match {
        case Some(items) => (items.get(PrincipalIdColumn).getS, items.get(EnabledColumn).getBOOL)
        case _ => ("unknown", false)
      }
    } catch {
      case exception: Throwable =>
        println(exception.getMessage)
        ("unknown", false)
    }
  }
}
