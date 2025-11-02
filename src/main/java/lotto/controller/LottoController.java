package lotto.controller;

import java.util.List;
import lotto.service.InputParser;
import lotto.validation.InputValidator;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public void run() {
        long purchaseAmount = inputParser.parseToLong(inputView.readPurchaseAmount());
        inputValidator.validatePurchaseAmount(purchaseAmount);
        List<Integer> winningNumbers = inputParser.parseToIntegerList(inputView.readWinningNumbers());
        int bonusNumber = inputParser.parseToInteger(inputView.readBonusNumber());
    }
}
