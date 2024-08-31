package br.com.fatecomerce.api.repository;

import br.com.fatecomerce.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
