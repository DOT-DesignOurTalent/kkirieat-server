package io.dot.kkirieat.server.infra.auth;

import io.dot.kkirieat.server.domain.PassphraseEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPassphraseEncoder implements PassphraseEncoder {

    private final PasswordEncoder passwordEncoder;

    public DefaultPassphraseEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(CharSequence password) {
        return this.passwordEncoder.encode(password);
    }

}
