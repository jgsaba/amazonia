package br.com.jorge.amazonia.products.service;

import br.com.jorge.amazonia.products.dto.ProductDTO;
import br.com.jorge.amazonia.products.exceptions.ProductNotFoundException;
import br.com.jorge.amazonia.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO findProductByProductIdentifier(String productIdentifier){
        return ProductDTO.fromProduct(productRepository.findByProductIdentifier(productIdentifier)
                .orElseThrow(() -> new ProductNotFoundException(productIdentifier)));
    }
}
