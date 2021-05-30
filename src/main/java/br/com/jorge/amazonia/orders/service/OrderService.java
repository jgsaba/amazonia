package br.com.jorge.amazonia.orders.service;

import br.com.jorge.amazonia.customers.dto.CustomerDTO;
import br.com.jorge.amazonia.customers.service.CustomerService;
import br.com.jorge.amazonia.orders.entity.Order;
import br.com.jorge.amazonia.orders.dto.NewOrderDTO;
import br.com.jorge.amazonia.orders.dto.OrderDTO;
import br.com.jorge.amazonia.orders.exception.OrderNotFoundException;
import br.com.jorge.amazonia.orders.repository.OrderRepository;
import br.com.jorge.amazonia.products.entity.Product;
import br.com.jorge.amazonia.products.dto.ProductDTO;
import br.com.jorge.amazonia.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OrderDTO placeOrder(NewOrderDTO newOrder){
        CustomerDTO customer = customerService.getCustomerByCpf(newOrder.getCustomerCpf());

        List<ProductDTO> productDTOList = newOrder.getProductsIdentifiers().stream()
                .map(this::getProductByIdentifier)
                .collect(Collectors.toList());

        Order order = Order.builder()
                .customer(customer.toCustomer())
                .products(productDTOList.stream().map(ProductDTO::toProduct).collect(Collectors.toList()))
                .placedAt(LocalDate.now())
                .build();

        return convertFromOrder(orderRepository.save(order));
    }

    public List<OrderDTO> getCustomerOrders(String cpf){
        return orderRepository.findByCustomer_cpf(cpf).stream().map(this::convertFromOrder).collect(Collectors.toList());
    }

    public void deleteOrder(Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
        orderRepository.delete(order);
    }

    private OrderDTO convertFromOrder(Order order){

        List<ProductDTO> products = order.getProducts().stream()
                .map(Product::toProductDTO)
                .collect(Collectors.toList());

        BigDecimal totalPrice = products.stream()
                .map(ProductDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return OrderDTO.builder()
                .customerDTO(CustomerDTO.fromCustomer(order.getCustomer()))
                .productDTOList(products)
                .placedAt(order.getPlacedAt())
                .totalPrice(totalPrice)
                .build();
    }

    private ProductDTO getProductByIdentifier(String productIdentifier){
        return productService.findProductByProductIdentifier(productIdentifier);
    }
}
