package com.hiring.JobPortal.Service;

import com.hiring.JobPortal.Model.PostModel;
import com.hiring.JobPortal.Repository.PostRepository;
import com.hiring.JobPortal.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SearchRepository searchRepository;

    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    public void addPost(PostModel post) {
        postRepository.save(post);
    }

    public List<PostModel> search(String token) {
        return searchRepository.search(token);
    }
}
