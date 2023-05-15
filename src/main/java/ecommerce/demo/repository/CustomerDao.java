package ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.demo.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

    public Customer findByMobileNumber(String mobileNumber);

}
