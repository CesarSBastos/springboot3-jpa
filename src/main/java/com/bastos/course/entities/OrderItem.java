package com.bastos.course.entities;

import com.bastos.course.entities.pk.OrdemItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();
    private Integer quantity;

    private double price;

    public OrderItem(){}

    public OrderItem(Order order, Product product, Integer quantity, double price) {
        this.quantity = quantity;
        this.price = price;
        id.setOrder(order);
        id.setProduct(product);
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }


    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getSubtotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
