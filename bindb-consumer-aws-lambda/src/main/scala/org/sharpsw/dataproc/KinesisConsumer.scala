package org.sharpsw.dataproc

import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.Context

class KinesisConsumer {
  def processMessages(event: KinesisEvent, context: Context): String = {
    "OK"
  }
}
