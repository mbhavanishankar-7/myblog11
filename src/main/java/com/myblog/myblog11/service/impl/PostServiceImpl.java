package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.Postdto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Postdto createPost(Postdto postdto) {

        Post post = mapToEntity(postdto);
        Post savedPost = postRepository.save(post);

        Postdto dto = mapToDto(savedPost);
        return dto;
    }

    @Override
    public Postdto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post Not Found with Id:"+id)

        );

        Postdto dto = new Postdto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
//Paging
    @Override
    public List<Postdto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
       Sort sort= (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNo,pageSize, sort);
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> posts = pagePost.getContent();

        List<Postdto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }

    Postdto mapToDto(Post post){
        Postdto dto = new Postdto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
    Post mapToEntity(Postdto postdto){
        Post post = new Post();
        post.setTitle(postdto.getTitle());
        post.setDescription(postdto.getDescription());
        post.setContent(postdto.getContent());
        return post;
    }



}
