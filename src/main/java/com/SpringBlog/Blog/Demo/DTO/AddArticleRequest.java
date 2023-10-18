package com.SpringBlog.Blog.Demo.DTO;

import com.SpringBlog.Blog.Demo.domain.Article;

public class AddArticleRequest {
    public String title;
    public String content;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
