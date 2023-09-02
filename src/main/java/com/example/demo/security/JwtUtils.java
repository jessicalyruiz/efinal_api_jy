package com.example.demo.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;


 @Component
public class JwtUtils {
	
	private static final Logger LOG=LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwt.secret}")
	private String jwtSecret;
	
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			// TODO: handle exception
			LOG.error("token expirado {}",e.getMessage());
		}
		catch (SignatureException e) {
			// TODO: handle exception
			LOG.error("token invalido {}",e.getMessage());

		}
		return false;
	}
	 
	public String getUsrNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	

}

 