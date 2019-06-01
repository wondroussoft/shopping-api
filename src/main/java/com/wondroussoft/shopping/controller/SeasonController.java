package com.wondroussoft.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wondroussoft.shopping.model.entities.Season;
import com.wondroussoft.shopping.model.repo.CategoryRepository;
import com.wondroussoft.shopping.model.repo.ItemRepository;
import com.wondroussoft.shopping.model.repo.WearRepository;
import com.wondroussoft.shopping.model.service.SeasonService;

@Controller
public class SeasonController {

	@Autowired
	SeasonService servcSeason;

	@Autowired
	WearRepository repoWear;

	@Autowired
	CategoryRepository repoCategory;

	@Autowired
	ItemRepository repoItem;

	@GetMapping("/seasons")
	public String getSeasons(ModelMap map) {
		List<Season> seasons = servcSeason.getAllSeasons();

		map.put("seasons", seasons);

		return "seasons";
	}

	@GetMapping("/seasons/{seasonId}")
	public String getSeasonDetails(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Season season = servcSeason.getSeasonById(seasonId);

		map.put("season", season);

		return "season_detail";
	}

	@PostMapping("/season")
	public String createSeason(ModelMap map, @ModelAttribute Season season) {
		// Get the season from UI
		// Save it to DB

		servcSeason.saveSeason(season);

//		// Fetch all seasons from season table
//		List<Season> seasons = repoSeason.findAll();
//
//		// map it to seasons variable
//		map.put("seasons", seasons);
//
//		// return the seasons list page
//		return "seasons";

		return "redirect:/seasons";
	}

	@GetMapping("/season/{seasonId}/edit")
	public String getEditSeasonForm(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Season season = servcSeason.getSeasonById(seasonId);

		map.put("season", season);
		// return the create season page
		return "create_season";
	}

	@GetMapping("/season")
	public String getCreateSeasonForm(ModelMap map) {

		// return the create season page
		return "create_season";
	}

	@GetMapping("/season/{seasonId}")
	public String deleteSeason(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {

		// repoSeason.deleteById(seasonId);
		servcSeason.deleteSeason(seasonId);

		return "redirect:/seasons";
	}

}
