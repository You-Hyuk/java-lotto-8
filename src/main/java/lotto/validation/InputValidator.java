package lotto.validation;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstant;

public class InputValidator {

    public void validatePurchaseAmount(long purchaseAmount) {
        int price = LottoConstant.LOTTO_PRICE.getValue();

        if (purchaseAmount < price || purchaseAmount % price != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
