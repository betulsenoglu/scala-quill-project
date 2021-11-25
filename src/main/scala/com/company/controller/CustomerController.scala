package com.company.controller

import scala.concurrent.Future
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.company.repo.CustomerRepo
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.unmarshalling.Unmarshaller._
import com.company.model.Customer

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NoStackTrace
import scala.util.{Failure, Success}
import scala.concurrent.Future

class CustomerController(customerRepo: CustomerRepo)(implicit ec: ExecutionContext) extends SprayJsonSupport with DefaultJsonProtocol {
  //var customers: List[Customer] = Nil

  val route: Route =
    path("customers") {
      val maybeItem: Future[List[Customer]] = customerRepo.get()
      onComplete(maybeItem) {
        case Success(_) => complete(StatusCodes.OK)
        case Failure(_) => complete(StatusCodes.InternalServerError)
      }
    }

}
