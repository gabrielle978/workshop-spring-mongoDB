package com.gbs.workshopmongo.config;

import com.gbs.workshopmongo.domain.Post;
import com.gbs.workshopmongo.dto.authorDTO;
import com.gbs.workshopmongo.repository.userRepository;
import com.gbs.workshopmongo.domain.User;
import com.gbs.workshopmongo.repository.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class instantiation implements CommandLineRunner {

    //injeção de dependência
    @Autowired
    private userRepository userRepositoryConfig;

    @Autowired
    private postRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepositoryConfig.deleteAll();

        User gabi = new User(null, "Gabrielle Bassiquete", "gbassiquete@gmail.com");
        User maria = new User(null, "Maria", "maria@gmail.com");
        User alex = new User(null, "Alex", "alexex@gmail.com");
        User alice = new User(null, "Alice", "alice@gmail.com");

        //salvar primeiro os usuários p/ criar seus próprios id's
        userRepositoryConfig.saveAll(Arrays.asList(gabi, maria, alex, alice));

        Post post1= new Post(null, sdf.parse("21/03/2023"), "Bora viajar", "Me aguarde Bahia!", new authorDTO(maria));
        Post post2= new Post(null, sdf.parse("02/02/2026"), "Bom dia Brasil", "Ansiosa para a prova de hoje!", new authorDTO(gabi));

        //depois salva-se o post com o id do usuário
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
