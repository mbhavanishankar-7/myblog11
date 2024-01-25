package com.myblog.myblog11.service;

import com.myblog.myblog11.payload.Postdto;

import java.util.List;

public interface PostService {
    Postdto createPost(Postdto postdto);


    Postdto getPostById(long id);

    //paging
    List<Postdto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}
