package br.com.jorge.amazonia.orders.controller;

import br.com.jorge.amazonia.orders.dto.NewOrderDTO;
import br.com.jorge.amazonia.orders.dto.OrderDTO;
import br.com.jorge.amazonia.orders.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Place a new order")
    public OrderDTO placeOrder(@RequestBody NewOrderDTO newOrderDTO){
        return orderService.placeOrder(newOrderDTO);
    }

    @GetMapping("/customer/{customerCpf}")
    @ApiOperation(value = "Get customer's orders")
    public List<OrderDTO> getCustomerOrders(@PathVariable String customerCpf){
        return orderService.getCustomerOrders(customerCpf);
    }

    @DeleteMapping("/orderId")
    @ApiOperation(value = "Delete a given order")
    public void deleteAOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
    }
}
