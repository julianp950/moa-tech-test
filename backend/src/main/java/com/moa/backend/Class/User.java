package com.moa.backend.Class;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column (name = "age")
	private int age;
	@Column (name = "phone")
	private String phone;
	@Column (name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@ManyToOne (cascade = CascadeType.MERGE)
	private Role role;
	@Column(name = "token")
	private String token;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "token_expiration")
	private Date tokenExpiration;
}
