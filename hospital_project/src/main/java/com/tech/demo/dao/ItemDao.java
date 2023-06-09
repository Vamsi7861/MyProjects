package com.tech.demo.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.Item;
import com.tech.demo.repositry.ItemRepository;



@Repository
public class ItemDao {
	@Autowired
	ItemRepository repository;

	public Item saveItem(Item item) {
		return repository.save(item);
	}

	public Item updateItem(Item item) {
		return repository.save(item);
	}

	public Optional<Item> findItemById(int id) {
		return repository.findById(id);
	}

	public void delete(Item item) {
		repository.delete(item);
	}

	public List<Item> getAllItems() {
		return repository.findAll();
	}
}
