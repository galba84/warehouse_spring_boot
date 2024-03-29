package com.warehouse.wh.dao;

import com.warehouse.wh.Entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends CrudRepository<Article, Long> {

}