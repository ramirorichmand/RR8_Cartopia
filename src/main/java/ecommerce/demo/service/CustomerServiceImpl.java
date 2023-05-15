package ecommerce.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.demo.exceptions.CustomerException;
import ecommerce.demo.model.Address;
import ecommerce.demo.model.CurrentUserSession;
import ecommerce.demo.model.Customer;
import ecommerce.demo.model.CustomerDTO;
import ecommerce.demo.repository.CustomerDao;
import ecommerce.demo.repository.SessionDao;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao custDao;

    @Autowired
    private SessionDao sDao;

    @Override
    public Customer createCustomer(CustomerDTO customer) throws CustomerException {

        Customer existingCustomer= custDao.findByMobileNumber(customer.getMobileNumber());

        if(existingCustomer != null)
            throw new CustomerException("Customer Already Registered with Mobile number");

        // TODO Auto-generated method stub
        Customer cust = new Customer();
        cust.setUsername(customer.getName());
        cust.setEmail(customer.getEmail());
        cust.setMobileNumber(customer.getMobileNumber());
        cust.setPassword(customer.getPassword());
        custDao.save(cust);
        return cust;
    }

    @Override
    public Customer updateCustomer(CustomerDTO customer, String key) throws CustomerException{

        CurrentUserSession loggedInUser= sDao.findByUuid(key);

        if(loggedInUser == null) {
            throw new CustomerException("Please provide a valid key to update a customer");
        }

        if(customer.getId() == loggedInUser.getUserId()) {

            Customer cust = custDao.findById(customer.getId()).get();
            cust.setUsername(customer.getName());
            cust.setEmail(customer.getEmail());
            cust.setMobileNumber(customer.getMobileNumber());
            cust.setPassword(customer.getPassword());
            //If LoggedInUser id is same as the id of supplied Customer which we want to update
            return custDao.save(cust);
        }
        else
            throw new CustomerException("Invalid Customer Details, please login first");

    }
    @Override
    public Customer viewCustomer(Integer customerId,String key,Integer AdminId) throws CustomerException {

        CurrentUserSession loggedInUser= sDao.findByUuid(key);
        if(loggedInUser == null) {
            throw new CustomerException("Please provide a valid key to view customer details");
        }

        if(AdminId == loggedInUser.getUserId()) {

            // TODO Auto-generated method stub
            Customer customer = custDao.findById(customerId).get();
            if(customer != null ) {
                return customer;
            }
            else {
                throw new CustomerException("No Customer found");
            }
        }else {
            throw new CustomerException("Invalid Customer Details, please login first");
        }

    }
    @Override
    public List<Customer> viewCustomerAll(Integer AdminId,String key) throws CustomerException {

        CurrentUserSession loggedInUser= sDao.findByUuid(key);
        if(loggedInUser == null) {
            throw new CustomerException("Please provide a valid key to view customers details");
        }

        if(AdminId == loggedInUser.getUserId()) {

            // TODO Auto-generated method stub
            List<Customer> customerList = custDao.findAll();
            if(customerList.size() != 0) {
                return customerList;
            }
            else {
                throw new CustomerException("No Customer found");
            }
        }else {
            throw new CustomerException("wrong details please login first");
        }
    }


}
