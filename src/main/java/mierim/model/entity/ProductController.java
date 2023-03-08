/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mierim.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("productController")
@Scope("view")
public class ProductController {

    private List<Product> products = new ArrayList<Product>();
    private Product product;

    public ProductController() {

        product = new Product();
        product.setId(11);
        product.setNome("Vagner");
        product.setPreco(1.1);
        this.products.add(product);

        product = new Product();
        product.setId(12);
        product.setNome("Laura");
        product.setPreco(2.1);
        this.products.add(product);

        product = new Product();
        product.setId(13);
        product.setNome("Arthur");
        product.setPreco(3.1);
        this.products.add(product);

        product = new Product();
        product.setId(41);
        product.setNome("Denise");
        product.setPreco(6.1);
        this.products.add(product);

        product = new Product();
        product.setId(51);
        product.setNome("Seilá");
        product.setPreco(4.1);
        this.products.add(product);

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
