package org.sharpsw.dataproc.utils

import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.sharpsw.dataproc.data.BinRecord

object Queue {
  private val sqsService = AmazonSQSClientBuilder.standard.build

  def enqueue(record: BinRecord): Unit = {
    
  }
}
