package ecommerce.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cart")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductDtoSec> Cartproducts = new ArrayList<>();

}
