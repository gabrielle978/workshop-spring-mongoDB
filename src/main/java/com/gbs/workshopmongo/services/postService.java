package com.gbs.workshopmongo.services;

import com.gbs.workshopmongo.domain.Post;

import com.gbs.workshopmongo.repository.postRepository;
import com.gbs.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

//CAMADA 2 -> SERVIÇOS
@Service
public class postService {

    @Autowired
    private postRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

    }

    public List<Post> findByTitle(String text){
        return repository.findByTitle(text);
    }
}
