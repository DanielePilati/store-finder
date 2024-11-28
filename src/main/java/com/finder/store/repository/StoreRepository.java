package com.finder.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finder.store.model.Store;

public interface StoreRepository extends JpaRepository<Store, Integer>{

	List<Store> findByAddressContains(String address);
	
}
