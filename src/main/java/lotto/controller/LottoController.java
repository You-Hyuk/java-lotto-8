package lotto.controller;

import lotto.service.InputParser;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final InputParser inputParser = new InputParser();

    public void run() {
        Long purchaseAmount = inputParser.parseToLong(inputView.readPurchaseAmount());
        String rawWinningNumbers = inputView.readWinningNumbers();
        String rawBonusNumber = inputView.readBonusNumber();
    }
}
