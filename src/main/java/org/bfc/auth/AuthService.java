package org.bfc.auth;

import org.bfc.exception.BfcAuthException;
import org.bfc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUsername(username);
        return user;
    }

    public UserDetails signUp(SignUpRequest request) throws BfcAuthException {
        if (repository.findByUsername(request.username()) != null) {
            throw new BfcAuthException("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
        User newUser = new User(request.username(), encryptedPassword, request.role());
        return repository.save(newUser);
    }
}



