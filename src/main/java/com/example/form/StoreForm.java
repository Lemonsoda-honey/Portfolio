package com.example.form;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Store;
import com.example.user.util.EnabledItems;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreForm implements Serializable {

	private static final long serialVersionUID = 1L;


	private Integer id;

	@NotBlank
	@Size(max = 30)
	private String storename;

	@NotBlank
	@Size(max = 255)
	private String address;

	@NotBlank
	@Size(max = 120)
	private String url;

	private MultipartFile picture;

	private String freespace;

	private boolean isEnabled;

	private boolean isVegan;

	private boolean isOrganic;

	private boolean isCaff;

	private boolean isRestaurnat;

	private boolean isGoods;

	public Map<Boolean, String> getEnabledItems() {
		return EnabledItems.ENABLEDITEMS;
	}

	public Store toEntity() throws IOException{

		Store store = new Store();
		store.setId(this.getId());
		store.setStoreName(this.getStorename());
		store.setAddress(this.getAddress());
		store.setUrl(this.getUrl());

		if (this.getPicture().getName() == null) {
			store.setPicture(null);
		} else {
			store.setPicture(this.getPicture().getBytes());
		}
		

		if (this.getFreespace() == null) {
			store.setFreespace(null);
		} else {
			store.setFreespace(this.getFreespace().getBytes());
		}

		store.setEnabled(this.isEnabled());
		store.setIsVegan(this.isVegan());
		store.setIsOrganic(this.isOrganic());
		store.setIsCaff(this.isCaff());
		store.setIsRestaurnat(this.isRestaurnat());
		store.setIsGoods(this.isGoods());
		return store;
	}
}
