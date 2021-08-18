package com.example.service;

import java. util. LinkedHashMap;
import java. util. Map;

import org. springframework. stereotype. Service;

	@Service

	public class UserApplicationService {
		public Map < String, Integer > getVeganorganicMap() {
		Map < String, Integer > veganorganicMap = new LinkedHashMap <>(); 
		veganorganicMap. put("vegan", 1); veganorganicMap. put("organic", 2); 

	return veganorganicMap;

	}
}