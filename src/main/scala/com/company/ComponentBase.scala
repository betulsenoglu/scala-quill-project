package com.company

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import java.io.Closeable
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.ExecutionContext

trait ComponentBase {
  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer
  implicit val ec: ExecutionContext
  implicit val config: Config = ConfigFactory.load()
  protected def withClose[T <: Closeable](c: T): T = { system.registerOnTermination(c.close()); c }

}
