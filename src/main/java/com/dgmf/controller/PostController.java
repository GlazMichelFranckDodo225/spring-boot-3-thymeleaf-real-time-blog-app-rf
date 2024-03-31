package com.dgmf.controller;

import com.dgmf.dto.PostDto;
import com.dgmf.entity.Post;
import com.dgmf.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // Handler Method for GET All Posts Request
    // ==> Returns Model and Logical View Name
    @GetMapping("/admin/posts")
    public String post(Model model) {
        // Retrieve List of PostDto
        List<PostDto> postDtos = postService.findAllPosts();
        // Store "postDtos" into the Model Object
        model.addAttribute("posts", postDtos);
        // Returns the Logical Thymeleaf View Name
        return "/admin/posts";
    }
}
