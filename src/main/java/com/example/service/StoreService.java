package com.example.service;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.model.Store;

@Service
public interface StoreService {

	public Store save(Store store);

	public List<Store> findAll();

	public Store findOne(Integer id);

	public List<Store> findAll(Example<Store> of);
}
