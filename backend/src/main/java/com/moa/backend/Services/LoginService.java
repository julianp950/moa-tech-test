package com.moa.backend.Services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.moa.backend.Class.User;
import com.moa.backend.IntermediateClasses.UserData;
import com.moa.backend.IntermediateClasses.LoginData;
import com.moa.backend.Persistence.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;

@Service
public class LoginService {
	@Autowired
	private UserRepository repository;
	
	public UserData login(LoginData user) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		User loggingUser = repository.findByUserName(user.getUserName());
		
		if (Objects.nonNull(loggingUser)) {
			if (passwordEncoder.matches(user.getPassword(), loggingUser.getPassword())) {
				String token = getJWTToken(loggingUser.getUserName());
				loggingUser.setToken(token);
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 3);
				loggingUser.setTokenExpiration(cal.getTime());
				repository.save(loggingUser);
				UserData ud = new UserData(loggingUser.getId(), loggingUser.getName(), loggingUser.getToken(), loggingUser.getRole());
				return ud;
			}
		}
		return null;
	}
	
	public static String generateString() {
        return UUID.randomUUID().toString().replace("-", "");
	}

	public Boolean checkIfLogged(String token) {
		User loggedUser = repository.findByToken(token);
		if (Objects.nonNull(loggedUser)) {
			Date today = new Date();
			if (loggedUser.getTokenExpiration().after(today)) {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 3);
				loggedUser.setTokenExpiration(cal.getTime());
				repository.save(loggedUser);
				return true;
			}
		}
		return false;
	}
	
	private String getJWTToken(String username) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		String secretKey = "C81CBD833EA526BFAF6F4CBAEECCD5A8141C38A1DFF26B2134DDFA75A1";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		@SuppressWarnings("deprecation")
		String token = Jwts.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				.signWith(SignatureAlgorithm.HS256,
						secretKey.getBytes())
				.compact();
		return "Bearer " + token;
	}
}
