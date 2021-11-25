package com.company.repo;

import akka.actor.ActorSystem
import akka.http.scaladsl.coding.Decoder
import akka.http.scaladsl.model.StatusCodes._
import com.company.config.AppConfig
import com.company.model.{Customer, Subscription}
import io.getquill.LowerCase
import io.getquill.PostgresAsyncContext

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NoStackTrace


class CustomerRepo(ctx: PostgresAsyncContext[LowerCase.type])(implicit ec: ExecutionContext) {

  import ctx._
  object NotFound extends NoStackTrace

  private val customerQ = quote(querySchema[Customer]("Customer"))

  def get():Future[List[Customer]] = {
    ctx.run(customerQ).map(_.toList)
  }

}
