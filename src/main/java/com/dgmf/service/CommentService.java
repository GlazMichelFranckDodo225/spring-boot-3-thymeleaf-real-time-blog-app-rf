package com.dgmf.service;

import com.dgmf.dto.CommentDto;

public interface CommentService {
    void createComment(String postDtoUrl, CommentDto commentDto);
}
