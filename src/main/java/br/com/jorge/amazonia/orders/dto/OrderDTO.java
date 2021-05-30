package br.com.jorge.amazonia.orders.dto;

import br.com.jorge.amazonia.customers.dto.CustomerDTO;
import br.com.jorge.amazonia.products.dto.ProductDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    CustomerDTO customerDTO;
    List<ProductDTO> productDTOList;
    BigDecimal totalPrice;
    LocalDate placedAt;
}
