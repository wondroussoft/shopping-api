package com.wondroussoft.shopping.api.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondroussoft.shopping.api.model.service.SeasonService;
//import com.wondroussoft.shopping.model.entities.Category;
//import com.wondroussoft.shopping.model.entities.Item;
import com.wondroussoft.shopping.api.model.entities.Season;
//import com.wondroussoft.shopping.model.entities.Wear;
//import com.wondroussoft.shopping.model.repo.CategoryRepository;
//import com.wondroussoft.shopping.model.repo.ItemRepository;
import com.wondroussoft.shopping.api.model.repo.SeasonRepository;
//import com.wondroussoft.shopping.model.repo.WearRepository;

@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	SeasonRepository repoSeason;

//	@Autowired
//	WearRepository repoWear;
//
//	@Autowired
//	CategoryRepository repoCategory;
//
//	@Autowired
//	ItemRepository repoItem;

	public List<Season> getAllSeasons() {
		return repoSeason.findByX(false);
	}

	public Season saveSeason(Season season) {
		season.setX(false);
		return repoSeason.save(season);
	}

//	public Season deleteSeason(Long seasonId) {
//		Optional<Season> season = repoSeason.findById(seasonId);
//		Season newSeason = season.get();
//		newSeason.setX(true);
//		repoSeason.save(newSeason);
//
//		// Here you need to fetch all the related wears and then set x = true
//		// Fetch all wears from wear table
//		List<Wear> wears = repoWear.findBySeasonId(seasonId);
//
//		for (Wear wear : wears) {
//			wear.setX(true);
//			repoWear.save(wear);
//			List<Category> categories = repoCategory.findByWearId(wear.getId());
//			for (Category category : categories) {
//				category.setX(true);
//				repoCategory.save(category);
//				List<Item> items = repoItem.findByCategoryId(category.getId());
//				for (Item item : items) {
//					item.setX(true);
//					repoItem.save(item);
//				}
//			}
//		}
//
//		return newSeason;
//	}
//
//	public Season updateSeason(Season season) {
//		return repoSeason.save(season);
//	}

	public Season getSeasonById(Long seasonId) {
		return repoSeason.findById(seasonId).get();
	}

	@Override
	public Season deleteSeason(Long seasonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Season updateSeason(Season season) {
		// TODO Auto-generated method stub
		return null;
	}
}
