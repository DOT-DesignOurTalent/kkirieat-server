package io.dot.kkirieat.server.infra.auth;

import io.dot.kkirieat.server.domain.AuthenticationService;
import io.dot.kkirieat.server.domain.exception.BadCredentialsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class DefaultAuthenticationService implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    public DefaultAuthenticationService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public boolean authenticate(String id, String password) {
        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(id, password)
            );
            return authentication.isAuthenticated();
        } catch (BadCredentialsException e) {
            return false;
        }
    }
}