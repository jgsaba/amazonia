package br.com.jorge.amazonia.orders.repository;

import br.com.jorge.amazonia.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer_cpf(String cpf);
}
