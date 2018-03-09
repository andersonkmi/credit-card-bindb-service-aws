package org.sharpsw.sakura

import com.amazonaws.services.lambda.runtime.Context

object Main {
  def authenticate(event: Map[String, Object], context: Context): String = {
    val authToken = event("Authentication").toString
    println("Auth token: " + authToken)

    AuthResponse.generate
  }
}
