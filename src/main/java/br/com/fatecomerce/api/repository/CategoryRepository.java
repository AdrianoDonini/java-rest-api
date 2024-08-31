package br.com.fatecomerce.api.repository;


import br.com.fatecomerce.api.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categoria, Long> {

}
