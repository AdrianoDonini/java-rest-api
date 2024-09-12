package br.com.fatecomerce.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduct;

    @Column(name = "name_product", nullable = false, length = 300, unique = true)
    @NotBlank(message = "O nome do produto não pode estar vazio")
    @Length(min = 2, max = 300, message = "O nome do produto deve ter entre 2 e 300 caracteres!")
    private String nameProduct;

    @Column(name = "description_product", length=3000)
    @Length(min = 2, max = 300, message = "O campo descrição do produto deve ter entre 2 e 3000 caracteres!")
    @NotBlank(message = "O campo descrição do produto não pode ser vazio!")
    private String descriptionProduct;

    @Column(name = "sku_product", nullable = false, length = 10)
    @NotBlank(message = "O sku do produto não pode ser vazio!")
    private String skuProduct;

    @Column(name = "ean_product", nullable =  false, length = 15, unique = true)
    @NotBlank(message = "O campo ean do Produto não pode ser vazio!")
    private String eanProduct;

    @Column(name = "cost_price_product", nullable = false, precision = 10, scale = 2)
    @NotNull
    private BigDecimal costPriceProduct;

    @Column(name = "amout_product", nullable = false, precision = 10, scale = 2)
    @NotNull
    private BigDecimal amountProduct;

    @Column(name = "published_product", nullable = false , length = 1)
    private Boolean publishedProduct;

    @Column(name = "stock_product", length = 100)
    @NotNull
    private BigDecimal stockProduct;

    @Column(name = "date_created_product")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreatedProduct;

    @Column(name = "date_update_product")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateUpdateProduct;

    @PrePersist
    private void prePersist(){
        this.setPublishedProduct(false);
        this.setDateCreatedProduct(LocalDate.now());
    }
    @PreUpdate
    private void  preUpdate(){
        this.setDateUpdateProduct(LocalDate.now());
    }

}

