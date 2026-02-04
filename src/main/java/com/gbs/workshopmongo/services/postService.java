package com.gbs.workshopmongo.services;

import com.gbs.workshopmongo.domain.Post;

import com.gbs.workshopmongo.repository.postRepository;
import com.gbs.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
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

    public List<Post> fullSearch (String text, Date minDate, Date maxDate){
        //acréscimo de 1 dia / para considerar o dia inteiro da busca e não somente o instante
        //lembrando que o instante é declarado em milisegundos
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);

        return  repository.fullSearch(text, minDate, maxDate);
    }
}
