package com.nicolas.overflow.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.overflow.models.Tag;


@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Optional<Tag> findBySubject(String subject);
}
