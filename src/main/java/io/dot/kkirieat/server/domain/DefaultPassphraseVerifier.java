package io.dot.kkirieat.server.domain;

import io.dot.kkirieat.server.domain.exception.AuthenticationException;
import io.dot.kkirieat.server.domain.exception.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class DefaultPassphraseVerifier implements PassphraseVerifier {
    private final AuthenticationService authenticationService;

    public DefaultPassphraseVerifier(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void validate(String accountId, String passphrase) {
        if (!this.authenticationService.authenticate(accountId, passphrase)) {
            throw new AuthenticationException("passphrase is invalid", ErrorCode.INVALID_PASSPHRASE);
        }
    }
}