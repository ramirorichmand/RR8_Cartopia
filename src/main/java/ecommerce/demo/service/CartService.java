package ecommerce.demo.service;

import java.util.List;

import ecommerce.demo.exceptions.CartException;
import ecommerce.demo.exceptions.CustomerException;
import ecommerce.demo.model.Cart;
import ecommerce.demo.model.Product;
import ecommerce.demo.model.ProductDtoSec;

public interface CartService {

    public String addProductToCart(Integer customerId , Integer quantity,Integer productId,String key) throws CustomerException,CartException;

    public List<ProductDtoSec> getAllProduct(String key,Integer CustomerId) throws CustomerException,CartException;

    public String removeProductfromCart(Integer productId,String key,Integer customerId) throws CustomerException,CartException;

    public ProductDtoSec updateQuantity(Integer productId,Integer quantity,String key,Integer customerid) throws CustomerException,CartException;

    public Cart removeAllProduct(String key,Integer customerid) throws CustomerException,CartException;

}
