package br.com.fatecomerce.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fatecomerce.api.entity.Categoria;
import br.com.fatecomerce.api.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Categoria saveCategory(Categoria category){
        return categoryRepository.saveAndFlush(category);
    }

    public List<Categoria> getInfoCategories(){
        return categoryRepository.findAll();
    }

    public HashMap<String, Object> deleteCategory(Long idCategory) {
        Optional<Categoria> category =
                Optional.ofNullable(categoryRepository.findById(idCategory).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Categoria não encontrada!")));


        categoryRepository.delete(category.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Categoria: " + category.get().getNameCategory() +  " excluída com sucesso!");
        return result;
    }
    public Categoria findCategoryById(Long idCategory) {
        return categoryRepository.findById(idCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Categoria não encontrada!"));
    }

    public Categoria updateCategoria(Categoria categoria){
        if(findCategoryById(categoria.getIdCategory()) != null){
            return categoryRepository.saveAndFlush(categoria);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Caregoria não encontrada!");
        }
    }

}
