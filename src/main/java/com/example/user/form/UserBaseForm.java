package com.example.user.form;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.user.util.EnabledItems;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max = 30)
	private String displayName;

	private boolean isEnabled;

	public Map<Boolean, String> getEnabledItems() {
		return EnabledItems.ENABLEDITEMS;
	}
}
