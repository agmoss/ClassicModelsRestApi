package com.agmoss.ClassicModelsRestApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "orderdetails", schema = "classicmodels", catalog = "")
@IdClass(OrderdetailsEntityPK.class)
public class OrderdetailsEntity {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "quantityOrdered", nullable = false)
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    @Basic
    @Column(name = "priceEach", nullable = false, precision = 2)
    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    @Basic
    @Column(name = "orderLineNumber", nullable = false)
    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }


    private OrdersEntity order;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = OrdersEntity.class)
    @JoinColumn(name = "orderNumber",insertable = false, updatable = false)
    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailsEntity that = (OrderdetailsEntity) o;
        return orderNumber == that.orderNumber &&
                quantityOrdered == that.quantityOrdered &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
    }

}
