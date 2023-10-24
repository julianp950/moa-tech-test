package com.moa.backend.IntermediateClasses;

import com.moa.backend.Class.Role;

public class UserData {
	private Long id;
	private String name;
	private String token;
	private Role role;
	
	public UserData(Long id, String name, String token, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.token = token;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getToken() {
		return token;
	}
	
	public Role getRole() {
		return role;
	}
}
