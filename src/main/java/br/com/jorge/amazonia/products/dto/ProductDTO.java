package br.com.jorge.amazonia.products.dto;

import br.com.jorge.amazonia.products.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @JsonIgnore
    private Long id;

    private String title;
    private String productIdentifier;
    private BigDecimal price;

    public static ProductDTO fromProduct(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .productIdentifier(product.getProductIdentifier())
                .build();
    }

    public Product toProduct(){
        return Product.builder()
                .id(getId())
                .title(getTitle())
                .productIdentifier(productIdentifier)
                .price(price)
                .build();
    }
}
