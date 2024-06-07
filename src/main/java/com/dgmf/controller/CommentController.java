package com.dgmf.controller;

import com.dgmf.dto.CommentDto;
import com.dgmf.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // Handler Method for Create Form Submit Request
    @PostMapping("/{postUrl}/comments")
    public String createComment(
            @PathVariable("postUrl") String postDtoUrl,
            // Using CommentDto as Model Object
            @ModelAttribute("comment") CommentDto commentDto,
            Model model
    ) {
        commentService.createComment(postDtoUrl, commentDto);

        return "redirect:/post/" + postDtoUrl;
    }
}
