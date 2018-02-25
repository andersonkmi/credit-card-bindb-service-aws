package org.sharpsw.dataproc

import org.sharpsw.dataproc.AWSLambdaEnvVars.{IterationsCount, IterationsCountDefault}
import org.sharpsw.dataproc.aws.DynamoDB.putRecord
import org.sharpsw.dataproc.utils.JsonConverter

import scala.util.Properties

object SQSConsumer {
  def processMessages() : String = {
    val numberIterations: Int = Properties.envOrElse(IterationsCount, IterationsCountDefault).trim.toInt

    for(_ <- 0 until numberIterations) {
      val messages = BinSQSProcessor.getMessages
      println("# of messages: " + messages.size)
      process(messages)
    }
    "Done"
  }

  private def process(items: Map[String, String]) : Unit = {
    if (items.nonEmpty) {
      try {
        items.foreach(x => processSingleMessage(x))
      } catch {
        case exception: Throwable =>
          exception.printStackTrace
      }
    } else println("No messages to process")
  }

  private def processSingleMessage(item: (String, String)) : Unit = {
    if(putRecord(JsonConverter.convertBinInfo(item._2))) {
      BinSQSProcessor.deleteMessage(item._1)
    } else println("Message '" + item._2 + "' skipped")
  }
}
