package org.sharpsw.dataproc.utils

import java.nio.ByteBuffer

import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder
import com.amazonaws.services.kinesis.model.PutRecordRequest
import org.json4s.jackson.Serialization.write
import org.json4s.{DefaultFormats, Formats}
import org.sharpsw.dataproc.data.BinRecord
import org.slf4j.LoggerFactory

object Kinesis {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  private val logger = LoggerFactory.getLogger(getClass)
  private val kinesisService = AmazonKinesisClientBuilder.standard.build

  def putRecord(item: BinRecord, deliveryStream: String):Unit = {
    try {
      val json = write(item)
      logger.trace("Entering Kinesis::putRecord")
      logger.info("Sending information to Kinesis")
      val data = json + "\n"
      val putRecordRequest = new PutRecordRequest()
      putRecordRequest.setStreamName(deliveryStream)
      putRecordRequest.setPartitionKey("partition-key-" + item.bin)
      putRecordRequest.setData(ByteBuffer.wrap(data.getBytes))
      val result = kinesisService.putRecord(putRecordRequest)
      logger.info("Information sent to Kinesis sucessfully: record_id => '" + result.getSequenceNumber + "'")
    }
    catch {
      case exception: Throwable => logger.error("Error when sending record to Kinesis: " + exception.getMessage); throw exception
    } finally {
      logger.trace("Leaving Kinesis::putRecord")
    }
  }
}
