package com.wondroussoft.shopping.api.model.service;

import java.util.List;

import com.wondroussoft.shopping.api.model.entities.Season;

public interface SeasonService {
	Season getSeasonById(Long seasonId);
	List<Season> getAllSeasons();
	Season saveSeason(Season season);
	Season deleteSeason(Long seasonId);
	Season updateSeason(Season season);
}
