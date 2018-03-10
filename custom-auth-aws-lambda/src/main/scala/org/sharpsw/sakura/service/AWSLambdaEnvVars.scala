package org.sharpsw.sakura.service

object AWSLambdaEnvVars {
  val AuthenticationDynamoDBTable = "AUTH_TABLE_NAME"
  val AuthenticationDynamoDBTableDefault = "SakuraAuthentication"

  val AuthenticationHeader = "AUTH_HEADER_NAME"
  val AuthenticationHeaderDefault = "Authentication"

  val MethodArnHeader = "METHOD_ARN"
  val MethodArnHeaderDefault = "methodArn"
}
