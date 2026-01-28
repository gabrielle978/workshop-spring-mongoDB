package com.gbs.workshopmongo.config;

import com.gbs.workshopmongo.repository.userRepository;
import com.gbs.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private userRepository userRepositoryConfig;

    @Override
    public void run(String... args) throws Exception {
        userRepositoryConfig.deleteAll();

        User gabi = new User(null, "Gabrielle Bassiquete", "gbassiquete@gmail.com");
        User maria = new User(null, "Maria", "maria@gmail.com");
        User alex = new User(null, "Alex", "alexex@gmail.com");

        userRepositoryConfig.saveAll(Arrays.asList(gabi, maria, alex));
    }
}
