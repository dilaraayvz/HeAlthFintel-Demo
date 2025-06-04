package com.mulakat.user_service.core.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mulakat.user_service.entities.User;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration}")
    private long jwtExpirationMillis;

    // application.yaml dosyasındaki secret-key den key üretiyoruz
    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    //  Token üretme
    public String generateToken(User user) {
        return Jwts.builder()
            .setSubject(user.getEmail())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 saat
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    

    // Token'dan kullanıcı adı çıkar
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Token geçerli mi kontrolü
    public boolean isTokenValid(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    //Token'ın claim'ini extract eden yardımcı metod
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Token'dan tüm claim'leri çıkar
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //  Token süresi geçmiş mi kontrol et
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Token expiration'ı çek
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
