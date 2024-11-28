package com.finder.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.store.model.Store;
import com.finder.store.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	StoreRepository storeRepo;
	
	public List<Store> getAll() {
		return storeRepo.findAll();
	}

	public Optional<Store> getByAddress(String address) {
		return storeRepo.findByAddress(address);
	}

	public Store save(Store store) {
		return storeRepo.save(store);

	}

	public Store update(Store store) {
		return storeRepo.save(store);
	}
	
	public void deleteById(Integer id) {
		storeRepo.deleteById(id);;
	}

	
}
