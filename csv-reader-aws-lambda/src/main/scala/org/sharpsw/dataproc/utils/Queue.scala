package org.sharpsw.dataproc.utils

import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.SendMessageRequest
import org.json4s.{DefaultFormats, Formats}
import org.sharpsw.dataproc.data.BinRecord
import org.sharpsw.dataproc.utils.AWSLambdaEnvVars.{RecordSQSUrl, RecordSQSUrlDefaultValue}
import org.slf4j.LoggerFactory
import org.json4s.jackson.Serialization.write

import scala.util.Properties._

object Queue {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  private val logger = LoggerFactory.getLogger(getClass)

  private val sqsService = AmazonSQSClientBuilder.standard.build

  def enqueue(record: BinRecord): Unit = {
    val json = write(record)
    val sqsMessageRequest = new SendMessageRequest().withQueueUrl(envOrElse(RecordSQSUrl, RecordSQSUrlDefaultValue)).withMessageBody(json).withDelaySeconds(5)
    val result = sqsService.sendMessage(sqsMessageRequest)
    logger.info(s"Information sent to queue: message_id = '${result.getMessageId}'; md5_body = '${result.getMD5OfMessageBody}'")
  }
}
