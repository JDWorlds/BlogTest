package com.SpringBlog.Blog.Demo.controller;

import com.SpringBlog.Blog.Demo.DTO.ArticleListViewResponse;
import com.SpringBlog.Blog.Demo.DTO.ArticleViewResponse;
import com.SpringBlog.Blog.Demo.domain.Article;
import com.SpringBlog.Blog.Demo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getarticle(Model model)
    {
        List<ArticleListViewResponse> articles = blogService.findAll().
                stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles",articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id==null){
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
