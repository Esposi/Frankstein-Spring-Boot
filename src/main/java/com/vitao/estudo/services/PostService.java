package com.vitao.estudo.services;

import com.vitao.estudo.models.Post;
import com.vitao.estudo.repositorys.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postrepository;

    public List<Post> getAllPosts(){
        return postrepository.findAll();
    }
}
