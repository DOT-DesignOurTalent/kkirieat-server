package io.dot.kkirieat.server.domain;

public interface PassphraseEncoder {
    String encode(CharSequence passphrase);
}
