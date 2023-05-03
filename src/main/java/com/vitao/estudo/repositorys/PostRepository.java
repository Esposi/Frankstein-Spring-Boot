package com.vitao.estudo.repositorys;

import com.vitao.estudo.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String>
{
    public List<Post> findByNome(String nome);

}
