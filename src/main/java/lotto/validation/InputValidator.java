package lotto.validation;

import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstant;

public class InputValidator {

    public void validatePurchaseAmount(long purchaseAmount) {
        int price = LottoConstant.LOTTO_PRICE.getValue();

        if (purchaseAmount < price || purchaseAmount % price != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void validateRawWinningNumbers(String rawWinningNumbers) {
        if (rawWinningNumbers.endsWith(Delimiter.WINNING_NUMBERS_DELIMITER.getDelimiter())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_ENDS_WITH_DELIMITER.getMessage());
        }
    }
}
