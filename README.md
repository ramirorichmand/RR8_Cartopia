# 10/05/23 RR8 Cartopia: Your Ultimate Shopping Companion! 🛍️🛒 

A REST API service for an Online Shopping Application. This exciting API allows customers to login to their profiles, update their information, and seamlessly navigate through a delightful shopping experience. Meanwhile, the admin oversees the operations, ensuring smooth functionality and access to valuable data within the Admin Module. 

## Tech Stack 👨‍🔧
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- PostgreSQL

## Features 🎨

- Data Authentication and Validation: authentication and validation mechanisms ensure secure access for both admins and customers 🔐 

### Admin Features
- Access to Order Details: Admins can effortlessly view all order details and obtain specific order details using a particular customer's ID.
- Product Management: Admins have the authority to add and remove products from the inventory.


### Customer Features
- Seamless Login: Customers can easily log in to the application using their mobile number and password.
- Profile Updates: Customers have the flexibility to update their information, ensuring accuracy and relevance.
- Cart Management: Customers can effortlessly add products to their carts, remove items, and even update quantities as desired.
- Order Placement and Cancellation: Customers can place orders for their desired products and cancel them when needed.


## Installation & Run 🔢
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/edb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint 🤖
```
https://localhost:8888/
```
## API Reference 🧑‍💻

### Login Requests

```http
  Admin Login
```
| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Login` | `http://localhost:8888/loginAdmin` | Login Admin |
| `GET` | `Logout` | `http://localhost:8888/logoutAdmin` | Logout Admin |

```http
   Customer Login
```
| Request | METHOD     |  URI | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Login` | `http://localhost:8888/loginCustomer` | Login Customer |
| `GET` | `Logout` | `http://localhost:8888/logoutCustomer` | Logout Customer |


### Admin Requests

```http
  Admin Controller
```

| Request | METHOD     |  URL | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Create` | `http://localhost:8888/admin/create` | Create Admin |
| `PUT` | `Update` | `http://localhost:8888/admin/update` | Update Admin |
| `DELETE` | `Delete` | `http://localhost:8888/admin/delete` | Delete Admin |
| `POST` | `Create Product` | `http://localhost:8888/admin/createProduct` | Create Product |
| `GET` | `Get All Orders` | `http://localhost:8888/admin/getAllOrders` | Get All Orders |
| `GET` | `Get All Product` | `http://localhost:8888/admin/getAllProduct` | Get All Product |
| `GET` | `Get Product By Id` | `http://localhost:8888/admin/getProductById` | Get Product By Id |
| `DELETE` | `Remove Product` | `http://localhost:8888/admin/removeProduct` | Remove Product |
| `PUT` | `Update Product` | `http://localhost:8888/admin/updateProduct` | Update Product |
| `GET` | `Find All Customer` | `http://localhost:8888/admin/findAllCustomer` | Find All Customer |
| `GET` | `Find Customer By Id` | `http://localhost:8888/admin/findCustomerById` | Find Customer By Id |

### Customer Requests

```http
  Customer Controller
```


| Request | METHOD     |  URL | Description                |
| :-------- | :------- | :----- | :------------------------- |
| `POST` | `Create` | `http://localhost:8888/customer/create` | Create Customer |
| `PUT` | `Update` | `http://localhost:8888/customer/update` | Update Customer |
| `GET` | `Add To Cart` | `http://localhost:8888/customer/addToCart` | Add To Cart |
| `GET` | `Update Quantity` | `http://localhost:8888/customer/updatingQuantity` | Update Quantity Of Product |
| `GET` | `Get All Product` | `http://localhost:8888/customer/getAllProductAddedInCart` | Get All Product Added In Cart |
| `DELETE` | `Remove Product From Cart` | `http://localhost:8888/customer/removeProductFromCart` | Remove Product From Cart |
| `DELETE` | `Remove All Product From Cart` | `http://localhost:8888/customer/removeAllProductfromCart` | Remove All Product From Cart |
| `POST` | `Order Product` | `http://localhost:8888/customer/orderProduct` | Order |
| `GET` | `Get Order By Id` | `http://localhost:8888/customer/getOrderById` | Get Order By Id |
| `DELETE` | `Cancel Order` | `http://localhost:8888/customer/cancelOrder` | Cancel Order |

## Show Your Support 🤝

<b> Thank you </b> for taking the time to drop by and check out this Backend API Project ☺️

If you've liked or found this project helpful, please consider giving it a star 🌟 and supporting me on my journey to improve my programming skills and chase my aspirations. I'd love to hear your feedback on this project, so feel free to leave your thoughts and suggestions. 

Every contribution counts and is deeply appreciated as I pursue a path of lifelong learning and aim to share meaningful content for the seasoned shopaholic and budding fashionista community alike. 

Thank you again for your support! 🙏

<a href="https://www.buymeacoffee.com/ramiro.richmand"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" style="height: 41px !important;width: 174px !important;box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;-webkit-box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;"  target="_blank"></a>
