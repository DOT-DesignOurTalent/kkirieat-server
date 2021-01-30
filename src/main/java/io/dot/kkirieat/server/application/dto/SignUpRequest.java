package io.dot.kkirieat.server.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {
    private String email;
    private String password;
    private String nickname;
}
