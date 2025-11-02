package lotto.enums;

public enum ErrorMessage {
    INVALID_NUMBER_INPUT("입력값은 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
