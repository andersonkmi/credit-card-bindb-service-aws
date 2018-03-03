package org.sharpsw.dataproc

import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.Context
import scala.collection.JavaConverters._

class KinesisConsumer {
  def processMessages(event: KinesisEvent, context: Context): String = {
    val records = event.getRecords.asScala.map(item => {
      item.getKinesis.getData.array().map(_.toChar).mkString
    })
    "OK"
  }
}
