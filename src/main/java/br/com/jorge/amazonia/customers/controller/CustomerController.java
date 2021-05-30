package br.com.jorge.amazonia.customers.controller;

import br.com.jorge.amazonia.customers.dto.CustomerDTO;
import br.com.jorge.amazonia.customers.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation(value = "Insert a new customer")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO insertNewCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.insertCustomer(customerDTO);
    }

    @ApiOperation(value = "Update an existing customer")
    @PutMapping
    public CustomerDTO updateCustomer(@RequestParam String cpf, @RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(cpf, customerDTO);
    }
}
