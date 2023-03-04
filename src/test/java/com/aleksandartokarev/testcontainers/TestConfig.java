//package com.aleksandartokarev.testcontainers;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.testcontainers.containers.PostgreSQLContainer;
//
//@Configuration
//@EnableAutoConfiguration
//@Profile("test")
//public class TestConfig {
//
//    public static PostgreSQLContainer<?> postgreSQLContainer;
//
//    static {
//        postgreSQLContainer = new PostgreSQLContainer<>("postgres:11-alpine")
//                .withDatabaseName("integration-tests-db")
//                .withUsername("sa")
//                .withPassword("sa");
//        postgreSQLContainer.start();
//    }
//}
