package com.wondroussoft.shopping.model.repo;

import org.springframework.stereotype.Repository;
import com.wondroussoft.shopping.model.entities.Item;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	        List<Item> findByCategoryId(Long categoryId);
	        Optional<Item> findById(Long Id);
	
	
}
