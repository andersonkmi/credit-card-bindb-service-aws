package org.sharpsw.dataproc

import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.ReceiveMessageRequest
import org.json4s.{DefaultFormats, Formats}
import scala.collection.JavaConverters._


trait SQSDataProcessor {
  def getSqsUrl: String
  def getLongPoolingWaitTime : String
  def getMaxNumberMessages: String

  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  private val sqsService = AmazonSQSClientBuilder.standard.build

  def getMessages: Map[String, String] = {
    val receiveRequest = new ReceiveMessageRequest()
      .withQueueUrl(getSqsUrl)
      .withMaxNumberOfMessages(getMaxNumberMessages.toInt)
      .withWaitTimeSeconds(getLongPoolingWaitTime.toInt)
    val messages = sqsService.receiveMessage(receiveRequest).getMessages.asScala
    Map(messages map {x => (x.getReceiptHandle, x.getBody)} : _*)
  }

  def deleteMessage(handle: String): Unit = {
    sqsService.deleteMessage(getSqsUrl, handle)
  }

}