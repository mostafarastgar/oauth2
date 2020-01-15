package com.mostafa.oauth2.authservice.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.mostafa.oauth2.authservice.repository")
public class MongoConfig {

}
