package hu.schonherz.blog.data.repository;

import hu.schonherz.blog.data.domain.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Integer> {
}
