package com.company
import com.company.config.AppConfig
import com.company.controller.CustomerController
import com.company.repo.CustomerRepo
import io.getquill.{LowerCase, PostgresAsyncContext}

import scala.concurrent.ExecutionContext

trait _Components extends ComponentBase {

  implicit lazy val appConfig: AppConfig = new AppConfig(config)

  /** Data stores */
  implicit lazy val postgresCtxLower: PostgresAsyncContext[LowerCase.type] =
    withClose(new PostgresAsyncContext(LowerCase, appConfig.postgresConfig))


  /** Repos */
  implicit lazy val customerRepo = new CustomerRepo(postgresCtxLower)

  /** Services */

  /** Controllers */
  implicit lazy val customerController = new CustomerController(customerRepo = customerRepo)

  /** Processors */
}
