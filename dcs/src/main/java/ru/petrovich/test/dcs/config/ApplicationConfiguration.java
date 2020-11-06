package ru.petrovich.test.dcs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ru.petrovich.test.dcs.repository")
public class ApplicationConfiguration {
}
