package br.com.jorge.amazonia.customers.dto;

import br.com.jorge.amazonia.customers.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @JsonIgnore
    private Long id;

    private String cpf;
    private String name;
    private String email;
    private String address;

    public static CustomerDTO fromCustomer(Customer customer){
        return CustomerDTO.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }

    public Customer toCustomer(){
        return Customer.builder()
                .id(getId())
                .cpf(getCpf())
                .name(getName())
                .email(getEmail())
                .address(getAddress())
                .build();
    }
}
