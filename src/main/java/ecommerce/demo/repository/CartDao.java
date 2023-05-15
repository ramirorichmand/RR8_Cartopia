package ecommerce.demo.repository;

import org.springframework.data.JpaRepository;

import ecommerce.demo.model.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

}