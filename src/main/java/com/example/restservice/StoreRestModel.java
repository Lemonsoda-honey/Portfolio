package com.example.restservice;




import com.example.model.Store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class StoreRestModel {

	public StoreRestModel(Store store){

		this.setId(store.getId());
		this.setStoreName(store.getStoreName());
		this.setAddress(store.getAddress());
		this.setUrl(store.getUrl());

		this.setPictureUrl(PICTURE_URL_PATH + store.getId());

		if (store.getFreespace() == null) {
			this.setFreespace(null);
		} else {
			this.setFreespace(new String(store.getFreespace()));
		}
	}
	private String PICTURE_URL_PATH = "/store/image/";

	private Integer id;

	private String storeName;

	private String address;

	private String url;

	private String pictureUrl;

	private String freespace;

}
