package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;

public class InputParser {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public long parseToLong(String rawNumber) {
        try {
            return Long.parseLong(rawNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public List<Integer> parseToIntegerList(String rawWinningNumbers) {
        try {
            return Arrays.stream(rawWinningNumbers.split(WINNING_NUMBERS_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

}
