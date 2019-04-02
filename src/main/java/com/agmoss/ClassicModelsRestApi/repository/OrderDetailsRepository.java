package com.agmoss.ClassicModelsRestApi.repository;

import com.agmoss.ClassicModelsRestApi.model.OrderdetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderdetailsEntity,Integer> {

    List<OrderdetailsEntity> findByorderNumber(Integer orderId); // Not really necessary
}
