package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stores")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 30, nullable = false)
	private Integer id;

	@Column(name = "storeName", length = 60, nullable = false)
	private String storeName;

	@Column(name = "address", length = 255, nullable = false)
	private String address;

	@Column(name = "url", length = 120, nullable = false)
	private String url;

	@Column(name = "picture", nullable = true, columnDefinition = "mediumblob")
	private byte[] picture;

	@Column(name = "freespace", length = 120, nullable = true)
	private byte[] freespace;
		
	@Column(name = "is_enabled", nullable = false)
	private boolean isEnabled;

	@Column(name = "is_vegan", nullable = true)
	private Boolean isVegan;

	@Column(name = "is_organic", nullable = true)
	private Boolean isOrganic;

	@Column(name = "is_caff", nullable = true)
	private Boolean isCaff;

	@Column(name = "is_restaurnat", nullable = true)
	private Boolean isRestaurnat;

	@Column(name = "is_goods", nullable = true)
	private Boolean isGoods;

}
