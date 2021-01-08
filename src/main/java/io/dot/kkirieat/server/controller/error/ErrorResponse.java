package io.dot.kkirieat.server.controller.error;

public class ErrorResponse {
    private ErrorBody error;

    public ErrorResponse(ErrorBody error) {
        this.error = error;
    }

    public ErrorBody getError() {
        return error;
    }

    public void setError(ErrorBody error) {
        this.error = error;
    }
}