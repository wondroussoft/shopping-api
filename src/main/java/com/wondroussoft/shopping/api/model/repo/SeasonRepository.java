package com.wondroussoft.shopping.api.model.repo;

import org.springframework.stereotype.Repository;

import com.wondroussoft.shopping.api.model.entities.Season;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Long> {
	List<Season> findAll();
	Optional<Season> findById(Long id);
	List<Season> findByX(Boolean x);
}
