package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.MedOrder;



public interface MedOrderRepository extends JpaRepository<MedOrder, Integer> {

}
