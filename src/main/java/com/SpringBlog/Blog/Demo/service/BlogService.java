package com.SpringBlog.Blog.Demo.service;

import com.SpringBlog.Blog.Demo.DTO.AddArticleRequest;
import com.SpringBlog.Blog.Demo.DTO.UpdateArticleRequest;
import com.SpringBlog.Blog.Demo.domain.Article;
import com.SpringBlog.Blog.Demo.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest req){
        return blogRepository.save(req.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not Found :" + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest req){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException(("not found : " + id)));
        article.update(req.getTitle(), req.getContent());

        return article;
    }
}
