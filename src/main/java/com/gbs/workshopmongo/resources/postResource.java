 package com.gbs.workshopmongo.resources;

import com.gbs.workshopmongo.domain.Post;
import com.gbs.workshopmongo.resources.util.URL;
import com.gbs.workshopmongo.services.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping(value = "/fullsearch")
     public ResponseEntity<List<Post>> fullSearch (
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date minDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date maxDate){

        text = URL.decodeParam(text);
        //Date min = URL.convertDate(minDate, new Date(0L));
        //Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text,minDate, maxDate);
        return ResponseEntity.ok().body(list);
    }
     @ExceptionHandler(MethodArgumentTypeMismatchException.class)
     public ResponseEntity<String> handleTypeMismatch(Exception e) {
         return ResponseEntity.badRequest()
                 .body("Formato de data inválido. Use yyyy-MM-dd");
     }


 }
