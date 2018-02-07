package br.com.stefanini.pocjwt.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	static final long EXPIRATION_TIME = 860_000_000;
	static final String SECRET = "MySecret";
	static final String HEADER_STRING = "Authorization";
	
	public static String addAuthentication(String username) {
		String JWT = Jwts.builder()
					.setSubject(username)
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS512, SECRET)
					.compact();
		return JWT;
	}
	
	static String getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if(token != null) {
			
			String user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			return user;
			
		}
		return null;
	}
}
