package lotto.enums;

public enum Delimiter {
    WINNING_NUMBERS_DELIMITER(",");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
