package com.SpringBlog.Blog.Demo.repository;

import com.SpringBlog.Blog.Demo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
