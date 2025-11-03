package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;

public final class InputParser {

    private InputParser() {}

    public static long parseToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public static List<Integer> parseToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(Delimiter.NUMBERS_DELIMITER.getDelimiter()))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    public static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

}
