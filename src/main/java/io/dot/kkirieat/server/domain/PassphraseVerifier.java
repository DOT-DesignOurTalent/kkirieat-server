package io.dot.kkirieat.server.domain;

public interface PassphraseVerifier {
    void validate(String accountId, String passphrase);
}
