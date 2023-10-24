package com.moa.backend.Class;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	
	/*
	 * Sets permissions for the role
	 * 
	 * ! This solution is NOT scalable and is only tailor-made for users CRUD !
	 * Should new permissions be needed this ought to be moved to a new class
	 */
	@Column (name = "permission_create")
	private boolean create;
	@Column (name = "permission_update")
	private boolean update;
	@Column (name = "permission_delete")
	private boolean delete;
}
