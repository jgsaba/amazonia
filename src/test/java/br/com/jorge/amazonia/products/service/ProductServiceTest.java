package br.com.jorge.amazonia.products.service;

import br.com.jorge.amazonia.products.dto.ProductDTO;
import br.com.jorge.amazonia.products.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void shouldFindAProduct(){
        ProductDTO product = productService.findProductByProductIdentifier("AG82UY85");

        assertEquals("Office chair XR2000", product.getTitle());
        assertEquals(BigDecimal.valueOf(119.99), product.getPrice());
    }

    @Test
    public void shouldNotFindAProduct(){
        assertThrows(ProductNotFoundException.class,
                () -> productService.findProductByProductIdentifier("DUMMY-T4G"));
    }
}