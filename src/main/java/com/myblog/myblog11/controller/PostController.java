package com.myblog.myblog11.controller;

import com.myblog.myblog11.payload.Postdto;
import com.myblog.myblog11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    public PostController(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;
    @PostMapping
    public ResponseEntity<Postdto> createPost(@RequestBody Postdto postdto){
        Postdto dto = postService.createPost(postdto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<Postdto> getPostById(@RequestParam long Id){
        Postdto dto = postService.getPostById(Id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy="title"
//Paging
    @GetMapping
    public List<Postdto> getAllPost(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "0") int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir
    ){
        List<Postdto> postsDto =postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
        return postsDto;
    }
}
