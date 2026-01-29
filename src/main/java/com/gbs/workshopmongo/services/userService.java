package com.gbs.workshopmongo.services;

import com.gbs.workshopmongo.domain.User;
import com.gbs.workshopmongo.dto.userDTO;
import com.gbs.workshopmongo.repository.userRepository;
import com.gbs.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//CAMADA 2 -> SERVIÇOS
@Service
public class userService {

    @Autowired
    private userRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert (User obj){
        return repository.insert(obj);
    }

    public void delete (String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update (User obj){
       User newObj = repository.findById(obj.getId())
                       .orElseThrow(() -> new RuntimeException("user not found"));
        updateData(newObj,obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO(userDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }


}
