package ru.perm.v.webflux1;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perm.v.webflux1.model.Article;


public interface ArticleRepository extends JpaRepository<Article,Long> {
}
