package io.dot.kkirieat.server.domain.exception;

public class AuthenticationException extends DefaultRuntimeException {
    public AuthenticationException() {
        super("authentication exception", ErrorCode.UNAUTHORIZED);
    }

    public AuthenticationException(ErrorCode errorCode) {
        super("authentication exception", errorCode);
    }

    public AuthenticationException(String message) {
        super(message, ErrorCode.UNAUTHORIZED);
    }

    public AuthenticationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause, ErrorCode.UNAUTHORIZED);
    }

    public AuthenticationException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public AuthenticationException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }

    public AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }
}
