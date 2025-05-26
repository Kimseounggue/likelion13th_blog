package likelion_13th.blog.repository;

import likelion_13th.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository <Article, Long>{

}
