package com.tk.learn.demo

import org.eclipse.store.integrations.spring.boot.types.configuration.EclipseStoreProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import software.xdev.spring.data.eclipse.store.repository.config.EclipseStoreClientConfiguration
import software.xdev.spring.data.eclipse.store.repository.config.EnableEclipseStoreRepositories

@SpringBootApplication
@EnableEclipseStoreRepositories
class EclipseStroreDemoApplication

fun main(args: Array<String>) {
	runApplication<EclipseStroreDemoApplication>(*args)
}