package io.dot.kkirieat.server.domain;

public interface PasswordEncoder {
    String bcryptEncryptor(String plainText);
    Boolean doPasswordsMatch(String rawPassword, String encodedPassword);
}
