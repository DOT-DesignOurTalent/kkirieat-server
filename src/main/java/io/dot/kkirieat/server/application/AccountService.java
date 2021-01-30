package io.dot.kkirieat.server.application;

import io.dot.kkirieat.server.application.dto.LoginRequest;
import io.dot.kkirieat.server.application.dto.SignUpRequest;
import io.dot.kkirieat.server.application.dto.SignUpResponse;
import io.dot.kkirieat.server.domain.Account;
import io.dot.kkirieat.server.domain.AccountRepository;
import io.dot.kkirieat.server.domain.PassphraseEncoder;
import io.dot.kkirieat.server.domain.PassphraseVerifier;
import io.dot.kkirieat.server.domain.exception.BadRequestException;
import io.dot.kkirieat.server.domain.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PassphraseEncoder passphraseEncoder;
    private final PassphraseVerifier passphraseVerifier;

    public AccountService (
            AccountRepository accountRepository,
            PassphraseEncoder passphraseEncoder,
            PassphraseVerifier passphraseVerifier
    ) {
        this.accountRepository = accountRepository;
        this.passphraseEncoder = passphraseEncoder;
        this.passphraseVerifier = passphraseVerifier;
    }

    @Transactional
    public SignUpResponse signUp(SignUpRequest request){
        accountRepository.save(
                Account.signup(
                    request.getEmail(),
                    this.passphraseEncoder.encode(request.getPassphrase()),
                    request.getNickname())
        );
        return SignUpResponse.of(request.getNickname());
    }

    @Transactional
    public void login(LoginRequest request){
        String email = request.getEmail();
        Account account = accountRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException(String.format("user email '%s' does not exist", email), ErrorCode.EMAIL_DOES_NOT_EXIST));
        this.passphraseVerifier.validate(account.getEmail(), request.getPassphrase());
        this.accountRepository.save(account);
    }
}
