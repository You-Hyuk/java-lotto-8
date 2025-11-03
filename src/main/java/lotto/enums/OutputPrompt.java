package lotto.enums;

public enum OutputPrompt {
    PURCHASE_COUNT("개를 구매했습니다.");

    private final String message;

    OutputPrompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
