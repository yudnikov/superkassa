package ru.yudnikov.database.postgres

import com.typesafe.config.Config

case class PostgresSettings(host: String, port: Int, database: String, login: String, password: String)

object PostgresSettings {
  def apply(config: Config): PostgresSettings = {
    val host = config.getString("postgres.host")
    val port = config.getInt("postgres.port")
    val database = config.getString("postgres.database")
    val login = config.getString("postgres.login")
    val password = config.getString("postgres.password")
    PostgresSettings(host, port, database, login, password)
  }
}
