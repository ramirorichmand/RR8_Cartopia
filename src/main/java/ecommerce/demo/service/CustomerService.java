package ecommerce.demo.service;

import java.util.List;

import ecommerce.demo.exceptions.CustomerException;
import ecommerce.demo.model.Customer;
import ecommerce.demo.model.CustomerDTO;
public interface CustomerService {

    public Customer createCustomer(CustomerDTO customer) throws CustomerException;

    public Customer updateCustomer(CustomerDTO customer, String key) throws CustomerException;

    public Customer viewCustomer(Integer customerId, String key, Integer AdminId) throws CustomerException;

    public List<Customer> viewCustomerAll(Integer AdminId, String key) throws CustomerException;
}
