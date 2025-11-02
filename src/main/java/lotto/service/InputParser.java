package lotto.service;

import lotto.enums.ErrorMessage;

public class InputParser {

    public long parseToLong(String rawNumber) {
        try {
            return Long.parseLong(rawNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }
}
