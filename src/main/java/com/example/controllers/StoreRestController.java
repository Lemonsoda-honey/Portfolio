package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Store;
import com.example.restservice.StoreRestModel;
import com.example.service.StoreService;

@RestController
@RequestMapping("store-rest-api")
public class StoreRestController {

	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("detail/{id}")
	public StoreRestModel greeting(@PathVariable("id") Integer id) {
		// ファイル情報を取得
		Store storeDate = storeService.findOne(id);
		StoreRestModel storeModel = new StoreRestModel(storeDate);
		return storeModel;
	}	
}

