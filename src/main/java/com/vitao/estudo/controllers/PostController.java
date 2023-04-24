package com.vitao.estudo.controllers;

import com.vitao.estudo.models.Post;
import com.vitao.estudo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public List<Post> getAllPostObjetct(){

        return postService.getAllPosts();
    }

    @PostMapping(value = "/addPosts")

    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }
}
