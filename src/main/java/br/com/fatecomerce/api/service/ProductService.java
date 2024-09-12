package br.com.fatecomerce.api.service;

import java.time.LocalDate;
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
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.saveAndFlush(product);
    }

    public List<Product> getInfoCategories(){
        return productRepository.findAll();
    }

    public HashMap<String, Object> deleteProduct(Long idProduct) {
        Optional<Product> Product =
                Optional.ofNullable(productRepository.findById(idProduct).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Produto não encontrado!")));


        productRepository.delete(Product.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Produto: " +  Product.get().getNameProduct() +  " excluída com sucesso!");
        return result;
    }
    public Product findProductById(Long idProduct) {
        return productRepository.findById(idProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrada!"));
    }

    public Product updateProduct(Product product){
        if(findProductById(product.getIdProduct()) != null){
            return productRepository.saveAndFlush(product);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
    }

    public Product findProductByEan(String eanProduct){
        return (productRepository.findByEanProduct(eanProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Nenhum produto encontrado pelo Ean: " + eanProduct)));


    }

    public Product findProductBySku(String skuProduct){
        return (productRepository.findBySkuProduct(skuProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Nenhum produto encontrado pelo SKU: " + skuProduct)));

    }
    public Product findProductByName(String nameProduct){
        return (productRepository.findByNameProductIgnoreCaseContaining(nameProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Nenhum produto encontrado pelo Nome: " + nameProduct)));

    }

    public  List<Product> findProductByDateCreated(LocalDate dateCreatedProduct)
    {
        List<Product> prodList = productRepository.findByDateCreated(dateCreatedProduct);
        if(prodList.isEmpty()){
             new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum produto encontrado pela data informada!");
        }
        return prodList;
    }
}
