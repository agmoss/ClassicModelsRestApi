package com.agmoss.ClassicModelsRestApi.repository;

import com.agmoss.ClassicModelsRestApi.model.OrderdetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderdetailsEntity,Integer> {

    List<OrderdetailsEntity> findByorderNumber(Integer orderId); // Not really necessary
}
