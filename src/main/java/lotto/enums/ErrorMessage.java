package lotto.enums;

public enum ErrorMessage {
    INVALID_NUMBER_INPUT("입력값은 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 나누어 떨어져야 합니다."),
    WINNING_NUMBERS_ENDS_WITH_DELIMITER("당첨 번호 입력은 쉼표(,)로 끝날 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_BOUND("로또 번호는 1 이상 45 이하의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
