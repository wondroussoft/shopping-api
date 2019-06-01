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

import com.wondroussoft.shopping.model.entities.Category;
import com.wondroussoft.shopping.model.entities.Season;
import com.wondroussoft.shopping.model.entities.Wear;
import com.wondroussoft.shopping.model.repo.CategoryRepository;
import com.wondroussoft.shopping.model.repo.WearRepository;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	WearRepository repoWear;

	@GetMapping("/wears/{wearId}/categories")
	public String getCategoryByWearId(ModelMap map, @PathVariable(name = "wearId") Long wearId) {
         
		Optional<Wear> wear = repoWear.findById(wearId);
		
        List<Category> categories = repoCategory.findByWearId(wearId);
        
        map.put("wear", wear.get());
		map.put("categories", categories);

		return "categories";
	}
	@PostMapping("/wears/{wearId}/category")
	public String createCategory(ModelMap map, @ModelAttribute Category category, @PathVariable(name = "wearId") Long wearId) {
		
		repoCategory.save(category);

		Optional<Wear> wear = repoWear.findById(wearId);

		
		List<Category> categories = repoCategory.findByWearId(wearId);

		
		map.put("categories", categories);
		map.put("wear", wear.get());

		
		return "categories";
	}
	@GetMapping("/category/{categoryId}/edit")
	public String getEditCategoryForm(ModelMap map,@PathVariable(name = "categoryId") Long categoryId) {
		Optional<Category> category=repoCategory.findById(categoryId);
		map.put("category",category.get());
		return "create_category";
	}

	@GetMapping("/wears/{wearId}/category")
	public String getCreateCategoryForm(ModelMap map, @PathVariable(name = "wearId") Long wearId) {

		map.put("wear_id", wearId);

		return "create_category";
	}

	@GetMapping("/wears/{wearId}/category/{categoryId}")
	public String deleteCategory(ModelMap map, @PathVariable(name = "categoryId") Long categoryId,
			@PathVariable(name = "wearId") Long wearId) {
		Optional<Wear> wear = repoWear.findById(wearId);

		//repoCategory.deleteById(categoryId);
		
		Optional<Category> category = repoCategory.findById(categoryId);
		Category newCategory = category.get();
		newCategory.setX(true);
		repoCategory.save(newCategory);

		
		List<Category> categories = repoCategory.findByWearId(wearId);

		
		map.put("categories", categories);
		map.put("wear", wear.get());

		
		return "categories";
	}
}



