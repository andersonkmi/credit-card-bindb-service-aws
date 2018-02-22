package org.sharpsw.dataproc

import org.sharpsw.dataproc.AWSLambdaEnvVars._

import scala.util.Properties

object BinSQSProcessor extends SQSDataProcessor {

  override def getSqsUrl: String = Properties.envOrElse(BinDbSqsUrl, BinDbSqsUrlDefault).trim

  override def getLongPoolingWaitTime: String = Properties.envOrElse(LongPoolingWait, LongPoolingWaitDefault).trim

  override def getMaxNumberMessages: String = Properties.envOrElse(MaxNumberOfMessages, MaxNumberOfMessagesDefault).trim

}
