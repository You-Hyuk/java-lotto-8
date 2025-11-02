package lotto.enums;

public enum LottoConstant {
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
