package hu.schonherz.jee.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.schonherz.jee.core.entity.PostEntity;

public interface PostDao extends JpaRepository<PostEntity, Long>{
    
}
