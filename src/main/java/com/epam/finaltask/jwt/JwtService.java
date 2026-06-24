package com.epam.finaltask.jwt;

import com.epam.finaltask.model.User;

public interface JwtService {
    String generateToken(User user);
    boolean verifyToken(String token);
    String extractUserEmail(String token);
}
