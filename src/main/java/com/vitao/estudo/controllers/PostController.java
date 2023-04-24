package com.vitao.estudo.controllers;

import com.vitao.estudo.models.Post;
import com.vitao.estudo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

@RestController
public class PostController
{
    @Autowired
    PostService postService;
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping(value = "/posts")

    public ResponseEntity<List<Post>> getAllPostObjetct(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @PostMapping(value = "/addPosts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> addPost(@RequestBody Post post) throws ServerException {

        Post responseObject = postService.addPost(post);
        if (responseObject == null) {
            throw new ServerException("Post error on Server");
        } else {
            return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/(id)")
    public ResponseEntity<Post> update(@PathVariable Integer id, @RequestBody Post post) throws Exception {
        Post altPostObjt = postService.updatePost(id, post);
        return ResponseEntity.ok().body(altPostObjt);
    }


}
