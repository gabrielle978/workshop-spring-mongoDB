package com.gbs.workshopmongo.dto;

import com.gbs.workshopmongo.domain.User;

import java.io.Serial;
import java.io.Serializable;

//DTO é um objeto que tem o papel de carregar dados das entidades de forma simples.

public class userDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public userDTO(){

    }

    public userDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
