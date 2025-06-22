// package com.bitsbytes.Product.security;

// import java.security.Key;
// import java.util.Base64;
// import java.util.Date;
// import java.util.List;
// import java.util.function.Function;

// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtUtil {

//     // ✅ Use a constant key (Base64 encoded 256-bit key)
//     private static final String SECRET_KEY = "a-very-strong-key-that-is-at-least-256-bits-long-for-HS256-algorithm";

//     public String generateToken(String username, List<String> roles) {
//         return Jwts.builder()
//             .setSubject(username)
//             .claim("roles", roles)
//             .setIssuedAt(new Date(System.currentTimeMillis()))
//             .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // 10 min
//             .signWith(getSignedKey(), SignatureAlgorithm.HS256)
//             .compact();
//     }

//     private Key getSignedKey() {
//         byte[] keyBytes = Decoders.BASE64.decode(Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()));
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     public Boolean validToken(String token, String username) {
//         return (extractUsername(token).equals(username) && !isTokenExpired(token));
//     }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     public Boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     public List<String> extractRole(String token) {
//         return extractClaim(token, claims -> claims.get("roles", List.class));
//     }

//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = Jwts.parserBuilder()
//             .setSigningKey(getSignedKey())
//             .build()
//             .parseClaimsJws(token) // ✅ FIXED HERE
//             .getBody();
//         return claimsResolver.apply(claims);
//     }
// }
