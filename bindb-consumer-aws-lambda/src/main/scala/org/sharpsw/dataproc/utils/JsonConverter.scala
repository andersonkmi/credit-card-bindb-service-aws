package org.sharpsw.dataproc.utils

import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization._
import org.sharpsw.dataproc.data.BinRecord

object JsonConverter {
  def convertBinInfo(json: String) : BinRecord = {
    implicit val formats = DefaultFormats
    read[BinRecord](json)
  }
}