package org.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.old.Message;

public class JwtUtil {

    private String secret = "secret";

    public JwtUtil() {
        System.out.println(this.generateToken());;
    }

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public Message parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            Message u = new Message();
            u.setContent((String) body.get("content"));

            return u;

        } catch (JwtException | ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String generateToken() {
        Claims claims = Jwts.claims();
        claims.put("content", "aaaaaa");

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }



}
