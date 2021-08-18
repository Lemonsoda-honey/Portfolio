package com.example.form;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreSearchForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean isVegan;

	private Boolean isOrganic;

	private Boolean isCaff;

	private Boolean isRestaurnat;

	private Boolean isGoods;

}
