package ru.perm.v.webflux1;

import org.springframework.data.repository.CrudRepository;
import ru.perm.v.webflux1.model.Article;


public interface ArticleRepository extends CrudRepository<Article, Long> {
}
