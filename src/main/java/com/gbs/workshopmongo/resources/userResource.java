package com.gbs.workshopmongo.resources;

import com.gbs.workshopmongo.domain.User;
import com.gbs.workshopmongo.dto.userDTO;
import com.gbs.workshopmongo.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/users")
@RestController
//CAMADA 1 -> CONTROLADORES REST
public class userResource {

    @Autowired
    private userService service;

    @GetMapping
    public ResponseEntity<List<userDTO>> findAll(){
        List<User> list = service.findAll(); //carrega lista de usuários
        List<userDTO> listDTO = list.stream().map(x -> new userDTO(x)) .collect(Collectors.toList()); //converte a lista User para userDTO
        return ResponseEntity.ok().body(listDTO); //metodo retorna o listDTO

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<userDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new userDTO(obj)); //metodo retorna o listDTO

    }
}
