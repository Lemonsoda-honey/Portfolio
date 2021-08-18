package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Store;

@SuppressWarnings("unused")
@Repository
public interface StoreRepository extends JpaRepository<Store, String> {

	@Query
	("select count(e) from Store e WHERE e.storeName = :storeName")
	long countByStoreName( String storeName);

	public List<Store> findAll();
	
	public Store getById(Integer id);
}

	
	
