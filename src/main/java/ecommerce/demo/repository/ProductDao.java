package ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.demo.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
