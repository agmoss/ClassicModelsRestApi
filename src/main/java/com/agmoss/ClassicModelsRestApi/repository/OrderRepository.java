package com.agmoss.ClassicModelsRestApi.repository;

import com.agmoss.ClassicModelsRestApi.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrdersEntity,Integer> {

}
