package io.dot.kkirieat.server.domain;

public interface AuthenticationService {
    boolean authenticate(String id, String passphrase);
}