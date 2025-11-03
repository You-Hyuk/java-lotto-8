package lotto.util;

import java.util.List;
import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

public final class InputValidator {

    private InputValidator () {}

    public static void validatePurchaseAmount(long purchaseAmount) {
        int price = LottoConstants.LOTTO_PRICE.getValue();

        if (purchaseAmount < price || purchaseAmount % price != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static void validateRawWinningNumbers(String rawWinningNumbers) {
        if (rawWinningNumbers.endsWith(Delimiter.NUMBERS_DELIMITER.getDelimiter())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_ENDS_WITH_DELIMITER.getMessage());
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumberCount(winningNumbers);
        validateDuplicateNumber(winningNumbers);
        winningNumbers.forEach(InputValidator::validateNumberRange);
    }

    public static void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
    }

    private static void validateDuplicateNumber(List<Integer> winningNumbers) {
        long distinctCount = winningNumbers.stream()
                .distinct()
                .count();

        if (distinctCount != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LottoConstants.MIN_NUMBER.getValue() || number > LottoConstants.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_BOUND.getMessage());
        }
    }
}
