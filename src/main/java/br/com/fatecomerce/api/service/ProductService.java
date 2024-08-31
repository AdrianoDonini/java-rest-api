package br.com.fatecomerce.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fatecomerce.api.entity.Product;
import br.com.fatecomerce.api.repository.ProductRepository;


@Service
public class ProductService {
    
    @Autowired
    private ProductRepository ProductRepository;

    public Product saveProduct(Product Product){
        return ProductRepository.saveAndFlush(Product);
    }

    public List<Product> getInfoCategories(){
        return ProductRepository.findAll();
    }

    public HashMap<String, Object> deleteProduct(Long idProduct) {
        Optional<Product> Product =
                Optional.ofNullable(ProductRepository.findById(idProduct).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Produto não encontrado!")));


        ProductRepository.delete(Product.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Produto: " + Product.get().getNameProduct() +  " excluída com sucesso!");
        return result;
    }
    public Product findProductById(Long idProduct) {
        return ProductRepository.findById(idProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrada!"));
    }

    public Product updateProduct(Product Product){
        if(findProductById(Product.getIdProduct()) != null){
            return ProductRepository.saveAndFlush(Product);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
    }
}
