package ecommerce.demo.service;

import java.util.List;

import ecommerce.demo.exceptions.CustomerException;
import ecommerce.demo.exceptions.OrderException;
import ecommerce.demo.model.AddressDto;
import ecommerce.demo.model.Orders;
import ecommerce.demo.model.Product;
import ecommerce.demo.model.ProductDtoSec;

public interface OrderService {
    public Orders OrderProducts(String key,Integer customerId,AddressDto Address) throws OrderException,CustomerException;

    public String cancelOrder(Integer orderId, String key, Integer customerId ) throws OrderException,CustomerException;

    public Orders getOrderById(Integer orderId,String key,Integer customerId) throws OrderException,CustomerException;

    public List<Orders> getAllOrders(String key,Integer adminId) throws OrderException,CustomerException;
}
