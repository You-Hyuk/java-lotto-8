package lotto.enums;

public enum InputPrompt {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    InputPrompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
