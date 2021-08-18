package com.example.user.form.sub;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.user.form.UserBaseForm;
import com.example.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm extends UserBaseForm {

	private static final long serialVersionUID = 1L;

	private static final String ALPHANUMERIC_REGEXP = "[a-zA-Z0-9.]*";

	private static final String ALPHANUMERIC_MESSAGE = "半角英字、数字、ピリオドを使用できます";

	@NotBlank
	@Size(max = 30)
	@Pattern(regexp = ALPHANUMERIC_REGEXP, message = ALPHANUMERIC_MESSAGE)
	private String username;

	@NotBlank
	@Size(max = 255)
	@Pattern(regexp = ALPHANUMERIC_REGEXP, message = ALPHANUMERIC_MESSAGE)
	private String password;

	@Override
	public String toString() {
		return "User(username: " + this.getUsername() + ", displayName: " + super.getDisplayName() + ", password: "
				+ this.getPassword() + ", isEnabled: " + super.isEnabled() + ")";
	}

	public User toEntity() {

		User user = new User();
		user.setUsername(this.getUsername());
		user.setDisplayName(super.getDisplayName());
		user.setPassword(this.getPassword());
		user.setEnabled(super.isEnabled());

		return user;
	}
}
