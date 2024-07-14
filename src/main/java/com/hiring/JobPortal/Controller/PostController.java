package com.hiring.JobPortal.Controller;

import com.hiring.JobPortal.Model.PostModel;
import com.hiring.JobPortal.Repository.Search;
import com.hiring.JobPortal.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/fetch/posts")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/fetch/posts/{token}")
    public List<PostModel> search(@PathVariable String token) {
        return postService.search(token);
    }

    @PostMapping("add/post")
    public String addPost(@RequestBody PostModel post) {
        postService.addPost(post);
        return "Post Added Sucessfully";
    }
}
