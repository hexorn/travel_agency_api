package com.epam.finaltask.jwt;

import com.epam.finaltask.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public class JwtServiceImpl implements JwtService {
    private final String secretKey;
    private final int tokenExpiration;
    private final int refreshTokenExpiration;

    JwtServiceImpl(@Value("${application.security.jwt.secret-key}") String secretKey,
                   @Value("${application.security.jwt.expiration}") int tokenExpiration,
                   @Value("${application.security.jwt.refresh-token.expiration}") int refreshTokenExpiration) {
        System.out.println("SECRET IS " + secretKey);
        this.secretKey = secretKey;
        this.tokenExpiration = tokenExpiration;
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    private SecretKey getSigningKey() {
        byte[] bytes = this.secretKey.getBytes();
        for(byte b : bytes) {
            System.out.println("SECRET IS " + b);
        }

        return Keys.hmacShaKeyFor(this.secretKey.getBytes());
    }

    @Override
    public String generateToken(User user) {
        Map<String, Object> claims = buildClaims(user);
        return buildToken(claims);
    }

//    private Map<String, Object> buildClaims(UserDetails userDetails) {
    private Map<String, Object> buildClaims(User userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof User customUserDetails) {
            claims.put("sub", customUserDetails.getUsername());
            claims.put("id", customUserDetails.getId());
//            claims.put("email", customUserDetails.getEmail());
            claims.put("role", customUserDetails.getRole());
        }
        return claims;
    }

    private String buildToken(Map<String, ?> claims) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + this.tokenExpiration))
                .signWith(this.getSigningKey())
                .compact();
    }

    public Optional<String> extractTokenFromHeader(String authHeader)  {
        if(authHeader == null) {
            return Optional.empty();
        }
        //token is not null
        if(!authHeader.startsWith("Bearer ")) {
            return Optional.empty();
        }
        //token is present(jwt/jwe)
        final String token = authHeader.split(" ")[1];

        return Optional.of(token);
    }


    @Override
    public String extractUserEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token)
                .getPayload();
    }
//    public Optional<String> extractEmail(String token) {
//        try {
//            Claims claims = Jwts.parser()     // (1)
//
////                    .keyLocator(keyLocator) // (2) dynamically locate signing or encryption keys
//                    //.verifyWith(key)      //     or a constant key used to verify all signed JWTs
//                    //.decryptWith(key)     //     or a constant key used to decrypt all encrypted JWTs
//                    .verifyWith(this.getSigningKey())
//                    .build()                // (3)
//
//                    .parseSignedClaims(token).getPayload();        // (4) or parseSignedClaims, parseEncryptedClaims, parseSignedContent, etc
//            return Optional.of(claims.get("email", String.class));
//            // we can safely trust the JWT
//        }
//        catch (JwtException ex) {   // (5)
//            System.out.println("ERROR extracting email claim" + ex.getMessage());
//            return Optional.empty();
//            // we *cannot* use the JWT as intended by its creator
//        }
//    }

//    public String generateToken(User user) {
//        //TODO
//        //TOKEN structure
//        //user email
//        //user role
//        return Jwts.builder().claim("role", user.getRole()).claim("email", user.getEmail()).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis() + tokenExpiration)).signWith(getSigningKey()).compact();
////        return "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiVVNFUiIsImVtYWlsIjoidGVzdFVzZXI0NzY5QGdtYWlsLmNvbSJ9.kYxcabF2GnebGvSgckWkvQvhLroLz7OEJ6zGVwKKZCeefbG5dogisozUVpZttD3tYBd15mBAdXJAZ1HyRcENwA";
//    }

//    private SecretKey getSigningKey() {
//        byte[] bytes = secretKey.getBytes();
//
//        for(byte b : bytes) {
//            System.out.println("SECRET IS " + b);
//        }
//
//        return Keys.hmacShaKeyFor(secretKey.getBytes());
//    }
//

    @Override
    public boolean verifyToken(String token) {
        try {
            Jwts.parser().verifyWith(this.getSigningKey()).build().parse(token);
            return true;
        } catch (JwtException e) {
            System.out.println("Token is invalid " + e.getMessage());
            return false;
        }
    }
}
