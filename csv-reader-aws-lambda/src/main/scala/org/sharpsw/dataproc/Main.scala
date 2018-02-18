package org.sharpsw.dataproc

import scala.collection.JavaConverters._
import java.net.URLDecoder
import com.amazonaws.services.lambda.runtime.events.S3Event

class Main {

  def getSourceBuckets(event: S3Event): String = {
    event.getRecords.asScala.foreach(item => {
      println(item.getS3.getObject.getKey)
      println(item.getS3.getBucket.getName)
    })
    "OK"
  }

  def decodeS3Key(key: String): String = URLDecoder.decode(key, "utf-8")
}
