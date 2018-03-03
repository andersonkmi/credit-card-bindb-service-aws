package org.sharpsw.dataproc

import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.Context
import org.sharpsw.dataproc.aws.DynamoDB.putRecord
import org.sharpsw.dataproc.utils.JsonConverter.convertBinInfo

import scala.collection.JavaConverters._

object KinesisConsumer {
  def processMessages(event: KinesisEvent, context: Context): String = {
    val records = event.getRecords.asScala.map(item => {
      item.getKinesis.getData.array().map(_.toChar).mkString
    })

    records.foreach(processMessage)
    "OK"
  }

  private def processMessage(record: String): Unit = {
    if(putRecord(convertBinInfo(record))) {
      println(s"Record $record saved successfully")
    } else println("Message '" + record + "' skipped")
  }
}
