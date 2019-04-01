package com.agmoss.ClassicModelsRestApi.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "classicmodels", catalog = "")
public class OrdersEntity {
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "orderDate", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "requiredDate", nullable = false)
    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Basic
    @Column(name = "shippedDate", nullable = false)
    public Date getShippedDate() {

        if (shippedDate == null){
            java.util.Date uDate = new java.util.Date();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            return sDate;
        } else {
            return shippedDate;
        }

    }

    public void setShippedDate(Date shippedDate) {
        if (shippedDate == null){
            java.util.Date uDate = new java.util.Date();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            this.shippedDate = sDate;
        } else {
            this.shippedDate = shippedDate;
        }

    }

    @Basic
    @Column(name = "status", nullable = false, length = 15)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = -1)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderNumber == that.orderNumber &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(requiredDate, that.requiredDate) &&
                Objects.equals(shippedDate, that.shippedDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDate, requiredDate, shippedDate, status, comments);
    }
}
