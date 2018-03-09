package org.sharpsw.sakura

import com.amazonaws.services.lambda.runtime.Context
import scala.collection.JavaConverters._

object Main {
  def authenticate(event: java.util.Map[String, Object], context: Context): String = {
    event.asScala.foreach(item => println(item._1))
    println(event.asScala.get("headers").toString)

    //println("headers")
    //headers.foreach(item => println(item._1))
    //println("Auth token: " + authToken)

    AuthResponse.generate
  }
}
