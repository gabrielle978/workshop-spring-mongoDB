package com.gbs.workshopmongo.repository;

import com.gbs.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//CAMADA 3 -> REPOSITORY DE ACESSO A DADOS
public interface userRepository extends MongoRepository<User, String> {
}
