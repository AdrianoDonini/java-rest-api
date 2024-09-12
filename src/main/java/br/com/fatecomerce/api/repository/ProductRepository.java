package br.com.fatecomerce.api.repository;

import br.com.fatecomerce.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByEanProduct(String eanProduct);

    Optional<Product> findBySkuProduct(String skuProduct);

    Optional<Product> findByNameProductIgnoreCaseContaining(String nameProduct);

    @Query(value = "SELECT c.* FROM product c WHERE c.date_created_product >= ?;", nativeQuery = true)
    List<Product> findByDateCreated(@Param("dateCreatedProduct")LocalDate dateCreatedProduct);
}
