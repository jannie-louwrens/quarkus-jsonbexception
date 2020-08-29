package me.louwrens.spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.louwrens.spring.hibernate.model.Category;
import me.louwrens.spring.hibernate.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
		return categoryRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping()
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

}
