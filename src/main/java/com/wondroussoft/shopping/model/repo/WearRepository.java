package com.wondroussoft.shopping.model.repo;

import org.springframework.stereotype.Repository;

import com.wondroussoft.shopping.model.entities.Wear;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface WearRepository extends CrudRepository<Wear, Long> {
	
	List<Wear> findAll();
	Optional<Wear> findById(Long id);
	List<Wear> findBySeasonId(Long seasonId);
	List<Wear> findBySeasonIdAndX(Long seasonId, Boolean x);
	
}
