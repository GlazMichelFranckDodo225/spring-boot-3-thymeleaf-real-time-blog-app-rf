package com.dgmf.mapper;

import com.dgmf.dto.CommentDto;
import com.dgmf.entity.Comment;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentMapper {
    private final ModelMapper modelMapper;

    // Convert Comment Entity to Comment DTO
    public CommentDto mapToCommentDto(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }

    // Convert Comment DTO to Comment Entity
    public Comment mapToCommentEntity(CommentDto commentDto) {
        return modelMapper.map(commentDto, Comment.class);
    }
}
