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

    public Post findByCodigo(String codigo) {
        return this.postRepository.findById(codigo).orElseThrow((() -> new IllegalArgumentException("Post not found, codigo - '" + codigo + "' não existe")));
    }
    public List<Post> findByNome(String nome) {
        return this.postRepository.findByNome(nome);
    }
    public List<Post> getAllPosts(){

        return postRepository.findAll();
    }

    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePost(String nome, Post post) throws Exception {
        List<Post> altPostObjt = findByNome(nome);
        altPostObjt.get(0).setData(post.getData());
        altPostObjt.get(0).setNumeroLong(post.getNumeroLong());
        altPostObjt.get(0).setArray(post.getArray());
        return postRepository.save(altPostObjt.get(0));
    }
}
