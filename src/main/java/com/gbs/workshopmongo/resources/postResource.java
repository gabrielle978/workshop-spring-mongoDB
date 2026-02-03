 package com.gbs.workshopmongo.resources;

import com.gbs.workshopmongo.domain.Post;
import com.gbs.workshopmongo.resources.util.URL;
import com.gbs.workshopmongo.services.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 @RequestMapping(value = "/posts")
@RestController
//CAMADA 1 -> CONTROLADORES REST
public class postResource {

    @Autowired
    private postService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "")String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
