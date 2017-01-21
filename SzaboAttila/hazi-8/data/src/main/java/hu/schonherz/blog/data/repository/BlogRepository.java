package hu.schonherz.blog.data.repository;

import hu.schonherz.blog.data.domain.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogPostEntity, Integer> {
}
