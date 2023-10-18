package com.SpringBlog.Blog.Demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UpdateArticleRequest {
    private String title;
    private String content;
}
