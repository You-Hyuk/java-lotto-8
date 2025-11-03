package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;

public class InputParser {

    public long parseToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public List<Integer> parseToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(Delimiter.NUMBERS_DELIMITER.getDelimiter()))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

}
