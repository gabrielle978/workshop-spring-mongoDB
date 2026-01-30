package com.gbs.workshopmongo.repository;

import com.gbs.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface postRepository extends MongoRepository<Post, String> {

}
