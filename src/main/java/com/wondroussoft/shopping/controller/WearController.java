package com.wondroussoft.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wondroussoft.shopping.model.entities.Season;
import com.wondroussoft.shopping.model.entities.Wear;
import com.wondroussoft.shopping.model.repo.SeasonRepository;
import com.wondroussoft.shopping.model.repo.WearRepository;

@Controller
public class WearController {

	@Autowired
	WearRepository repoWear;

	@Autowired
	SeasonRepository repoSeason;

	@GetMapping("/seasons/{seasonId}/wears")
	public String getWearsBySeasonId(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {
		Optional<Season> season = repoSeason.findById(seasonId);

		List<Wear> wears = repoWear.findBySeasonIdAndX(seasonId, false);

		map.put("season", season.get());
		map.put("wears", wears);

		return "wears";
	}

	@PostMapping("/seasons/{seasonId}/wear")
	public String createWear(ModelMap map, @ModelAttribute Wear wear, @PathVariable(name = "seasonId") Long seasonId) {
		// Get the wear from UI
		// Save it to DB

		repoWear.save(wear);

		Optional<Season> season = repoSeason.findById(seasonId);

		// Fetch all wears from wear table
		List<Wear> wears = repoWear.findBySeasonId(seasonId);

		// map it to wears variable
		map.put("wears", wears);
		map.put("season", season.get());

		// return the wears list page
		return "wears";
	}
	@GetMapping("/wear/{wearId}/edit")
	public String getEditWearForm(ModelMap map,@PathVariable(name = "wearId") Long wearId) {
		Optional<Wear> wear=repoWear.findById(wearId);
		map.put("wear",wear.get());
		return "create_wear";
	}
	

	@GetMapping("/seasons/{seasonId}/wear")
	public String getCreateWearForm(ModelMap map, @PathVariable(name = "seasonId") Long seasonId) {

		map.put("seasonId", seasonId);

		// return the create wear page
		return "create_wear";
	}

	@GetMapping("/seasons/{seasonId}/wear/{wearId}")
	public String deleteWear(ModelMap map, @PathVariable(name = "wearId") Long wearId,
			@PathVariable(name = "seasonId") Long seasonId) {
		Optional<Season> season = repoSeason.findById(seasonId);

		//repoWear.deleteById(wearId);
		
		
		
		
		Optional<Wear> wear = repoWear.findById(wearId);
		Wear newWear = wear.get();
		newWear.setX(true);
		repoWear.save(newWear);

		// Fetch all wears from wear table
		List<Wear> wears = repoWear.findBySeasonIdAndX(seasonId, false);

		// map it to wears variable
		map.put("wears", wears);
		map.put("season", season.get());

		// return the wears list page
		return "wears";
	}
}
