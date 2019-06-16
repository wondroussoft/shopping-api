package com.wondroussoft.shopping.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wondroussoft.shopping.api.model.service.SeasonService;
import com.wondroussoft.shopping.api.model.entities.Season;

@RestController
public class SeasonController {

	@Autowired
	SeasonService servcSeason;

//	@Autowired
//	WearRepository repoWear;
//
//	@Autowired
//	CategoryRepository repoCategory;
//
//	@Autowired
//	ItemRepository repoItem;

	@GetMapping(path = "/seasons", produces = "application/json")
	public ResponseEntity<Object> getSeasons() {
		List<Season> seasons = servcSeason.getAllSeasons();

		return new ResponseEntity<>(seasons, HttpStatus.OK);
	}

	@GetMapping("/seasons/{seasonId}")
	public String getSeasonDetails(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Season season = servcSeason.getSeasonById(seasonId);

		map.put("season", season);

		return "season_detail";
	}

	@PostMapping(path = "/season", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createSeason(@RequestBody Season season) {
		// Get the season from UI
		// Save it to DB
		if(season.getName() == null || season.getName().isEmpty()) {
			return new ResponseEntity<>("The season data is not valid", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		servcSeason.saveSeason(season);

		List<Season> seasons = servcSeason.getAllSeasons();

		return new ResponseEntity<>(seasons, HttpStatus.OK);
	}
//
//	@GetMapping("/season/{seasonId}/edit")
//	public String getEditSeasonForm(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
//		Season season = servcSeason.getSeasonById(seasonId);
//
//		map.put("season", season);
//		// return the create season page
//		return "create_season";
//	}
//
//	@GetMapping("/season")
//	public String getCreateSeasonForm(ModelMap map) {
//
//		// return the create season page
//		return "create_season";
//	}
//
//	@GetMapping("/season/{seasonId}")
//	public String deleteSeason(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
//
//		// repoSeason.deleteById(seasonId);
//		servcSeason.deleteSeason(seasonId);
//
//		return "redirect:/seasons";
//	}

}
