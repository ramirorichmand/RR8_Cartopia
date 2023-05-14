package ecommerce.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.demo.exceptions.CartException;
import ecommerce.demo.exceptions.CustomerException;
import ecommerce.demo.exceptions.OrderException;
import ecommerce.demo.model.AddressDto;
import ecommerce.demo.model.Cart;
import ecommerce.demo.model.Customer;
import ecommerce.demo.model.CustomerDTO;
import ecommerce.demo.model.Orders;
import ecommerce.demo.model.Product;
import ecommerce.demo.model.ProductDtoSec;
import ecommerce.demo.service.CartService;
import ecommerce.demo.service.CustomerService;
import ecommerce.demo.service.OrderService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    CustomerService custService;

    @Autowired
    CartService cservice;

    @Autowired
    OrderService orderService;



    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer( @RequestBody CustomerDTO cDTO) throws CustomerException{

        Customer cust = custService.createCustomer(cDTO);
        return new ResponseEntity<Customer>(cust,HttpStatus.OK);


    }
    @PutMapping("/update")
    public  ResponseEntity<Customer> updateCustomer(@Valid @RequestBody CustomerDTO customer,@RequestParam(required = false) String key ) throws CustomerException {


        Customer updatedCustomer= custService.updateCustomer(customer, key);

        return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);

    }

    @GetMapping("/cart")
    public ResponseEntity<String> addToCart(@RequestParam Integer customerId,@RequestParam Integer quantity,@RequestParam Integer productId ,@RequestParam String key) throws CartException, CustomerException{
        String mess = cservice.addProductToCart(customerId,quantity, productId,key);
        return new ResponseEntity<String>(mess, HttpStatus.OK);
    }
    @GetMapping("/getAllProductAddedInCart")
    public ResponseEntity<List<ProductDtoSec>> getAllProductAddedToCart(@RequestParam String key,@RequestParam Integer CustomerId) throws CartException, CustomerException{
        List<ProductDtoSec> products = cservice.getAllProduct(key,CustomerId);

        return new ResponseEntity<List<ProductDtoSec>>(products,HttpStatus.OK);

    }


    @PostMapping("/orderProduct")
    public ResponseEntity<Orders> Order(@RequestParam String key,@RequestParam Integer CustomerId,@RequestBody AddressDto addDto) throws OrderException, CustomerException{

        Orders order = orderService.OrderProducts(key,CustomerId,addDto);

        return new  ResponseEntity<Orders>(order,HttpStatus.OK);


    }
    @DeleteMapping("/removeProductFromCart")
    public ResponseEntity<String> removeProductFromCart(@RequestParam Integer productId,@RequestParam String key,@RequestParam Integer CustomerId) throws CustomerException, CartException{
        String mess = cservice.removeProductfromCart(productId, key, CustomerId);
        return new ResponseEntity<String>(mess, HttpStatus.OK);

    }

    @GetMapping("/updatingQuantity")
    public ResponseEntity<ProductDtoSec> updateQuantityOfProduct(@RequestParam Integer productId,@RequestParam Integer quantity,@RequestParam String key,@RequestParam Integer CustomerId ) throws CustomerException,CartException{
        ProductDtoSec productdto = cservice.updateQuantity(productId, quantity, key, CustomerId);
        return new  ResponseEntity<ProductDtoSec>(productdto,HttpStatus.OK);
    }

    @DeleteMapping("/removeAllProductfromCart")
    public ResponseEntity<Cart> removeAllProduct(@RequestParam String key,@RequestParam Integer customerId) throws CustomerException, CartException {
        Cart cart = cservice.removeAllProduct(key, customerId);
        return new  ResponseEntity<Cart>(cart,HttpStatus.OK);
    }
    @DeleteMapping("/cancelOrder")
    public ResponseEntity<String> CancelOrder(@RequestParam Integer orderId,@RequestParam String key,@RequestParam Integer customerid) throws OrderException, CustomerException{

        String mess = orderService.cancelOrder(orderId, key, customerid);
        return new ResponseEntity<String>(mess,HttpStatus.OK);

    }
    @GetMapping("/getOrderById")
    public ResponseEntity<Orders> getOrderByid(@RequestParam Integer orderId,@RequestParam String key,@RequestParam Integer customerid) throws OrderException, CustomerException {
        Orders order = orderService.getOrderById(orderId, key, customerid);
        return new ResponseEntity<Orders>(order,HttpStatus.OK);
    }


}
