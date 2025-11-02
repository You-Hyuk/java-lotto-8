package lotto.enums;

public enum ErrorMessage {
    INVALID_NUMBER_INPUT("입력값은 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
