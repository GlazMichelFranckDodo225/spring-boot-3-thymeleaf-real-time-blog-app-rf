package com.dgmf.service.impl;

import com.dgmf.dto.CommentDto;
import com.dgmf.entity.Comment;
import com.dgmf.entity.Post;
import com.dgmf.mapper.CommentMapper;
import com.dgmf.repository.CommentRepository;
import com.dgmf.repository.PostRepository;
import com.dgmf.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentMapper commentMapper;

    @Override
    public void createComment(String postDtoUrl, CommentDto commentDto) {
        // Retrieve Post Entity by Url
        Post post = postRepository.findByUrl(postDtoUrl).get();
        // Convert Comment Dto into Comment Entity
        Comment comment = commentMapper.mapToCommentEntity(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
