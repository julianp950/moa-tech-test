package com.moa.backend.Controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moa.backend.IntermediateClasses.UserData;
import com.moa.backend.IntermediateClasses.LoginData;
import com.moa.backend.Services.LoginService;

import io.jsonwebtoken.security.InvalidKeyException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService service;
	
	@PostMapping	
    public UserData login(@RequestBody LoginData user) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        return service.login(user);
    }
	
	@GetMapping(value = "/token/{token}")	
    public Boolean checkIfLogged(@PathVariable(name = "token") String token) {
        return service.checkIfLogged(token);
    }
}
