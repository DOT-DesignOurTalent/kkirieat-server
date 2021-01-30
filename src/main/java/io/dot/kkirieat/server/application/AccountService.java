package io.dot.kkirieat.server.application;

import io.dot.kkirieat.server.application.dto.LoginRequest;
import io.dot.kkirieat.server.application.dto.SignUpRequest;
import io.dot.kkirieat.server.application.dto.SignUpResponse;
import io.dot.kkirieat.server.domain.Account;
import io.dot.kkirieat.server.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request){

        accountRepository.save(
                Account.signup(
                    request.getEmail(),
                    request.getPassword(),
                    request.getNickname())
        );
        return SignUpResponse.of(request.getNickname());
    }

    @Transactional
    public void login(LoginRequest request){
        Account user = accountRepository.findByEmail(request.getEmail());

        accountRepository.save(user);
    }
}
