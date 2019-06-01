package com.wondroussoft.shopping.model.repo;

import org.springframework.stereotype.Repository;

import com.wondroussoft.shopping.model.entities.Category;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	//List<Category> findAll();
	Optional<Category>findById(Long id);
	List<Category>findByWearId(Long wearId);
	
	
}

