package br.com.jorge.amazonia.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderDTO {

    private String customerCpf;
    private List<String> productsIdentifiers;
}
