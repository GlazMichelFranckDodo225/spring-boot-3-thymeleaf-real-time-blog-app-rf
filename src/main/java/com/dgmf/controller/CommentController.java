package com.dgmf.controller;

import com.dgmf.dto.CommentDto;
import com.dgmf.dto.PostDto;
import com.dgmf.entity.Post;
import com.dgmf.service.CommentService;
import com.dgmf.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    // Handler Method for Create Form Submit Request
    @PostMapping("/{postUrl}/comments")
    public String createComment(
            @PathVariable("postUrl") String postDtoUrl,
            // Using CommentDto as Model Object
            @Valid @ModelAttribute("comment") CommentDto commentDto,
            // To Catch Errors
            BindingResult result,
            Model model
    ) {
        PostDto postDto = postService.findPostByUrl(postDtoUrl);

        // Check Errors to Return the UI
        if(result.hasErrors()) {
            model.addAttribute("post", postDto);
            model.addAttribute("comment", commentDto);

            // In Case Errors, Returns the Same UI
            return "blog/blog_post";
        }

        commentService.createComment(postDtoUrl, commentDto);

        return "redirect:/post/" + postDtoUrl;
    }
}
