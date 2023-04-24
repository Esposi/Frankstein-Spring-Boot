package com.vitao.estudo.services;

import com.vitao.estudo.models.Post;
import com.vitao.estudo.repositorys.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post findById(Integer id) throws Exception {
        Optional<Post> altPostObjt = postRepository.findById(id);
        return altPostObjt.orElseThrow((() -> new NoSuchElementException("Post not found - " + id)));
    }
    public List<Post> getAllPosts(){

        return postRepository.findAll();
    }

    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePost(Integer id, Post post) throws Exception {
        Post altPostObjt = findById(id);
        altPostObjt.setData(post.getData());
        altPostObjt.setNome(post.getNome());
        altPostObjt.setNumeroLong(post.getNumeroLong());
        altPostObjt.setArray(post.getArray());
        return postRepository.save(altPostObjt);
    }
}
