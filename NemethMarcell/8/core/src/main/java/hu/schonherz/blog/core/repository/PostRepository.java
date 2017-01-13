package hu.schonherz.blog.core.repository;

import hu.schonherz.blog.core.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Integer> {

}
