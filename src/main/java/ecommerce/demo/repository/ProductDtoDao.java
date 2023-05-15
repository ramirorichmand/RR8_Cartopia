package ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.demo.model.Product;
import ecommerce.demo.model.ProductDtoSec;

public interface ProductDtoDao extends JpaRepository<ProductDtoSec, Integer>{

}
