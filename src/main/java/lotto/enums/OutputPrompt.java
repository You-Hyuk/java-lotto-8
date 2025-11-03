package lotto.enums;

public enum OutputPrompt {
    PURCHASE_COUNT("개를 구매했습니다."),
    LOTTO_RESULT("당첨 통계\n" + "---");

    private final String message;

    OutputPrompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
