package com.gbs.workshopmongo.repository;

import com.gbs.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface postRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title':{$regex: ?0, $options: 'i'}} ")
    List<Post> findByTitle(String text);

    @Query(
            "{ $and: [" +
                    "  { date: { $gte: ?1 } }, " +
                    "  { date: { $lte: ?2 } }, " +
                    "  { $or: [" +
                    "      { title: { $regex: ?0, $options: 'i' } }, " +
                    "      { body: { $regex: ?0, $options: 'i' } }, " +
                    "      { 'comments.text': { $regex: ?0, $options: 'i' } } " +
                    "  ] } " +   // 👈 fecha ARRAY do $or E o OBJETO
                    "] }"
    )

    List<Post> fullSearch (String text, Date minDate, Date maxDate);
}
