package com.jamp.nosql.util;

import com.github.javafaker.Faker;
import com.jamp.nosql.models.*;
import com.jamp.nosql.storage.UserCouchbaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.Set;
import java.util.stream.IntStream;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final Faker faker = new Faker();

    @Autowired
    private UserCouchbaseRepository repository;

    /**
     * Used for initial DB filling with random users
     */
    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
//            IntStream.range(0, 7).forEach(i -> repository.save(createNewUser()));
        };
    }

    private User createNewUser() {

        Sport sport1 = new Sport(SportsList.random(), SportProficiency.random());
        Sport sport2 = new Sport(SportsList.random(), SportProficiency.random());

        return new User(faker.name().fullName(),
                faker.bothify("????##@mail.com"),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                Gender.random(),
                Set.of(sport1, sport2));

    }
}
