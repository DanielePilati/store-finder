package com.finder.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finder.store.model.Store;

public interface StoreRepository extends JpaRepository<Store, Integer>{

	Optional<Store> findByAddress(String address);
	
}
