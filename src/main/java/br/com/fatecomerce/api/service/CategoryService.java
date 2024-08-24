package br.com.fatecomerce.api.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecomerce.api.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.saveAndFlush(category);
    }

    public List<Category> getInfoCategories(){
        return categoryRepository.findAll();
    }

}
