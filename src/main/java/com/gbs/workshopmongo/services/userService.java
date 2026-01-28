package com.gbs.workshopmongo.services;

import com.gbs.workshopmongo.domain.User;
import com.gbs.workshopmongo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//CAMADA 2 -> SERVIÇOS
@Service
public class userService {

    @Autowired
    private userRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
