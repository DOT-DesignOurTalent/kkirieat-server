package io.dot.kkirieat.server.infra.auth;

import io.dot.kkirieat.server.domain.Account;
import io.dot.kkirieat.server.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Qualifier("accountDetailsService")
class DefaultAccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    public DefaultAccountDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public DefaultAccountDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = this.accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        return DefaultAccountDetails.of(account);
    }
}