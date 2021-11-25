package com.company

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.company.config.AppConfig
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.sslconfig.util.ConfigLoader

import scala.concurrent.ExecutionContext


object Boot extends App with _Components {
  override implicit val system: ActorSystem = ActorSystem("Boot")
  override implicit val materializer: ActorMaterializer = ActorMaterializer()
  override implicit val ec: ExecutionContext = system.dispatcher

  //import system.dispatcher
  Http()
    .bindAndHandle(customerController.route, "localhost", 8080)
}
