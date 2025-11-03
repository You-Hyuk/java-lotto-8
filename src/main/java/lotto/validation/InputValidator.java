package lotto.validation;

import java.util.List;
import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

public class InputValidator {

    public void validatePurchaseAmount(long purchaseAmount) {
        int price = LottoConstants.LOTTO_PRICE.getValue();

        if (purchaseAmount < price || purchaseAmount % price != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void validateRawWinningNumbers(String rawWinningNumbers) {
        if (rawWinningNumbers.endsWith(Delimiter.WINNING_NUMBERS_DELIMITER.getDelimiter())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_ENDS_WITH_DELIMITER.getMessage());
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumberCount(winningNumbers);
        validateDuplicateNumber(winningNumbers);
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateDuplicateNumber(List<Integer> winningNumbers) {
        long distinctCount = winningNumbers.stream()
                .distinct()
                .count();

        if (distinctCount != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < LottoConstants.MIN_NUMBER.getValue() || number > LottoConstants.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_BOUND.getMessage());
        }
    }
}
