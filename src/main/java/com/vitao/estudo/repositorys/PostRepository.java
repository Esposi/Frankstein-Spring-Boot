package com.vitao.estudo.repositorys;

import com.vitao.estudo.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>
{

}
