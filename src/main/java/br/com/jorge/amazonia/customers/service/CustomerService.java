package br.com.jorge.amazonia.customers.service;

import br.com.jorge.amazonia.customers.entity.Customer;
import br.com.jorge.amazonia.customers.repository.CustomerRepository;
import br.com.jorge.amazonia.customers.dto.CustomerDTO;
import br.com.jorge.amazonia.customers.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDTO updateCustomer(String cpf, CustomerDTO customerDTO){
        Customer customer = findCustomer(cpf);

        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());

        return CustomerDTO.fromCustomer(customerRepository.save(customer));
    }

    public CustomerDTO insertCustomer(CustomerDTO customerDTO){
        return CustomerDTO.fromCustomer(customerRepository.save(customerDTO.toCustomer()));
    }

    public CustomerDTO getCustomerByCpf(String cpf){
        return CustomerDTO.fromCustomer(findCustomer(cpf));
    }

    private Customer findCustomer(String cpf){
        return customerRepository.findByCpf(cpf)
                .orElseThrow(CustomerNotFoundException::new);
    }
}
