package com.company.config

import com.typesafe.config.Config

class AppConfig(config: Config) {
  val postgresConfig : Config = config.getConfig("postgres")

}
