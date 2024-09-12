package br.com.fatecomerce.api.controller;

import java.time.LocalDate;
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

import br.com.fatecomerce.api.entity.Product;
import br.com.fatecomerce.api.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product")
@CrossOrigin(value = "*")
public class ProductController {
            @Autowired
    private ProductService ProductService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getInfoCategories() {
        List<Product> result = ProductService.getInfoCategories();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveProduct(@RequestBody Product Product) {
        Product result = ProductService.saveProduct(Product);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @DeleteMapping(value = "/delete/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long idProduct) {
        HashMap<String, Object> result = ProductService.deleteProduct(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping(value = "/findProduct/{idProduct}")
    public ResponseEntity<Object> findProductByEan(@PathVariable Long idProduct){
        Product result = ProductService.findProductById(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product Product){
        Product result = ProductService.updateProduct(Product);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping(value = "/findProductByEan/{eanProduct}")
    public ResponseEntity<Object> findProductByEan(@PathVariable String eanProduct){
        Product result = ProductService.findProductByEan(eanProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping(value = "/findProductBySku/{skuProduct}")
    public ResponseEntity<Object> findProductBySku(@PathVariable String skuProduct){
        Product result = ProductService.findProductBySku(skuProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping(value = "/findProductByName/{nameProduct}")
    public ResponseEntity<Object> findProductByName(@PathVariable String nameProduct){
        Product result = ProductService.findProductByName(nameProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/findProductByDateCreated/{dateCreatedProduct}")
    public ResponseEntity<Object> findProductByDateCreated(@PathVariable LocalDate dateCreatedProduct) {
        List<Product> result = ProductService.findProductByDateCreated(dateCreatedProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
