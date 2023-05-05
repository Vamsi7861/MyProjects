package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.Item;



public interface ItemRepository extends JpaRepository<Item, Integer> {

}
