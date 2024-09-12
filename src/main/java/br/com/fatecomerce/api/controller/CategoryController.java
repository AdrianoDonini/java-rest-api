package br.com.fatecomerce.api.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecomerce.api.entity.Categoria;
import br.com.fatecomerce.api.service.CategoryService;

@RestController
@RequestMapping(value = "/api/v1/category")
@CrossOrigin(value = "*")
public class CategoryController {
        @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getInfoCategories() {
        List<Categoria> result = categoryService.getInfoCategories();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveCategory(@RequestBody Categoria category) {
        Categoria result = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @DeleteMapping(value = "/delete/{idCategory}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long idCategory) {
        HashMap<String, Object> result = categoryService.deleteCategory(idCategory);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping(value = "/findCategory/{idCategory}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long idCategory){
        Categoria result = categoryService.findCategoryById(idCategory);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateCategoria(@RequestBody Categoria categoria){
        Categoria result = categoryService.updateCategoria(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

