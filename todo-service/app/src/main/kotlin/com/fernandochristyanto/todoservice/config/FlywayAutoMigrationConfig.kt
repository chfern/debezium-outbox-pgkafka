package com.fernandochristyanto.todoservice.config

import org.flywaydb.core.Flyway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import javax.sql.DataSource

@Configuration
class FlywayAutoMigrationConfig(private val dataSource: DataSource) {
    @PostConstruct
    fun flywayMigrate() {
        val logger: Logger = LoggerFactory.getLogger(FlywayAutoMigrationConfig::class.java)
        logger.info("Migrating flyway scripts")

        val flyway = Flyway.configure()
                .dataSource(dataSource)
                .load()
        flyway.migrate()
    }
}