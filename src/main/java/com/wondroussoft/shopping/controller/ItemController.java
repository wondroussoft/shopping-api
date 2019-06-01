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
import com.wondroussoft.shopping.model.entities.Item;
import com.wondroussoft.shopping.model.entities.Season;
import com.wondroussoft.shopping.model.entities.Wear;
import com.wondroussoft.shopping.model.repo.CategoryRepository;
import com.wondroussoft.shopping.model.repo.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	ItemRepository repoItem;

	@GetMapping("/categories/{categoryId}/items")
	public String getItemByCategoryId(ModelMap map, @PathVariable(name = "categoryId") Long categoryId) {
		Optional<Category> category=repoCategory.findById(categoryId);
		
		List<Item> items = repoItem.findByCategoryId(categoryId);
		map.put("category",category.get());

		map.put("items", items);

		return "items";
	}

	@GetMapping("/items/{itemId}")
	public String getItemDetails(ModelMap map, @PathVariable(name = "itemId") Long itemId) {

		Optional<Item> item = repoItem.findById(itemId);

		map.put("item", item.get());

		return "item_detail";
	}

	@PostMapping("/categories/{categoryId}/item")
	public String createItem(ModelMap map, @ModelAttribute Item item, @PathVariable(name = "categoryId") Long categoryId) {
		
		repoItem.save(item);

		Optional<Category> category = repoCategory.findById(categoryId);

		
		List<Item> items = repoItem.findByCategoryId(categoryId);

		
		map.put("items", items);
		map.put("category", category.get());

		
		return "items";
	}
	
	@GetMapping("/item/{itemId}/edit")
	public String getEditItemForm(ModelMap map,@PathVariable(name = "itemId") Long itemId) {
		Optional<Item> item=repoItem.findById(itemId);
		map.put("item",item.get());
		return "create_item";
	}

	@GetMapping("/categories/{categoryId}/item")
	public String getCreateItemForm(ModelMap map, @PathVariable(name = "categoryId") Long categoryId) {

		map.put("category_id", categoryId);

		return "create_item";
	}

	@GetMapping("/categories/{categoryId}/item/{itemId}")
	public String deleteItem(ModelMap map, @PathVariable(name = "itemId") Long itemId,
			@PathVariable(name = "categoryId") Long categoryId) {
		Optional<Category> category = repoCategory.findById(categoryId);

		//repoItem.deleteById(itemId);
		Optional<Item> item = repoItem.findById(itemId);
		Item newItem = item.get();
		newItem.setX(true);
		repoItem.save(newItem);

		
		List<Item> items = repoItem.findByCategoryId(categoryId);

		
		map.put("items", items);
		map.put("category", category.get());

		
		return "items";
	}
}



