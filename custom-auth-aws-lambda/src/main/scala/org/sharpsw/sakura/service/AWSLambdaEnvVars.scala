package org.sharpsw.sakura.service

object AWSLambdaEnvVars {
  val AuthenticationDynamoDBTable = "AUTH_TABLE_NAME"
  val AuthenticationDynamoDBTableDefault = "SakuraAuthentication"

  val AuthorizationHeader = "AUTHORIZATION_HEADER_NAME"
  val AuthorizationHeaderDefault = "authorization"

  val MethodArnHeader = "METHOD_ARN"
  val MethodArnHeaderDefault = "methodArn"
}
