package com.hiring.JobPortal.Repository;

import com.hiring.JobPortal.Model.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<PostModel, String> {
}
