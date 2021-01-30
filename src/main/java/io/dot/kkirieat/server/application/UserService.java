package io.dot.kkirieat.server.application;

import io.dot.kkirieat.server.application.dto.LoginRequest;
import io.dot.kkirieat.server.application.dto.SignUpRequest;
import io.dot.kkirieat.server.application.dto.SignUpResponse;
import io.dot.kkirieat.server.domain.User;
import io.dot.kkirieat.server.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request){
        User user = User.signup(
                request.getEmail(),
                request.getPassword(),
                request.getNickname()
        );
        userRepository.save(user);
        return SignUpResponse.of(request.getNickname());
    }

    @Transactional
    public void login(LoginRequest request){
        User user = User.login(
            request.getEmail(),
            request.getPassword()
        );

        userRepository.save(user);
    }
}
