package com.dgmf.mapper;

import com.dgmf.dto.PostDto;
import com.dgmf.entity.Post;

public class PostMapper {
    // Map Post Entity to PostDto
    public static PostDto mapToPostDto(Post post) {
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .url(post.getUrl())
                .title(post.getTitle())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();

        return postDto;
    }

    // Map PostDto to Post Entity
    public static Post mapToPost(PostDto postDto) {
        Post post = Post.builder()
                .id(postDto.getId())
                .url(postDto.getUrl())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();

        return post;
    }
}
