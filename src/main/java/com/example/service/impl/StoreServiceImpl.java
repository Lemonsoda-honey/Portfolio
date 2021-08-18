package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Store;
import com.example.repository.StoreRepository;
import com.example.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	private StoreRepository repository;

	@Autowired
	public StoreServiceImpl(StoreRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public Store save(Store store) {
		return repository.save(store);
	}

	@Override
	public List<Store> findAll() {
		return repository.findAll();
	}

	@Override
	public Store findOne(Integer id) {
		return repository.getById(id);
	}
	@Override
	public List<Store> findAll(Example<Store> of) {
		return repository.findAll(of);
	}
}
