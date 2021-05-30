package br.com.jorge.amazonia.products.entity;

import br.com.jorge.amazonia.products.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "product_identifier", nullable = false, unique = true)
    private String productIdentifier;

    private BigDecimal price;

    public ProductDTO toProductDTO(){
        return ProductDTO.builder()
                .price(this.price)
                .title(this.title)
                .productIdentifier(this.productIdentifier)
                .build();
    }
}
