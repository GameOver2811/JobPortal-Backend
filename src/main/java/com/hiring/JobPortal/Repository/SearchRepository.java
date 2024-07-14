package com.hiring.JobPortal.Repository;

import com.hiring.JobPortal.Model.PostModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository{
    List<PostModel> search(String token);
}
