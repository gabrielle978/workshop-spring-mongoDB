package com.gbs.workshopmongo.repository;

import com.gbs.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface postRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
