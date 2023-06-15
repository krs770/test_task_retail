package com.example.test_task_retail.repository;

import com.example.test_task_retail.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {

//    Optional<Price> findByNetworkNameAndProductCode(String network, int productCode);
//
//    void setRegularPrice(Price price);
}

