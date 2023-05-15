package ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.demo.model.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer>{

}
