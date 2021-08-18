package com.example.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username", length = 30, nullable = false)
	private String username;

	@Column(name = "display_name", length = 60, nullable = false)
	private String displayName;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "is_enabled", nullable = false)
	private boolean isEnabled;

}
