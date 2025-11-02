package lotto.controller;

import java.util.List;
import lotto.service.InputParser;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final InputParser inputParser = new InputParser();

    public void run() {
        Long purchaseAmount = inputParser.parseToLong(inputView.readPurchaseAmount());
        List<Integer> rawWinningNumbers = inputParser.parseToIntegerList(inputView.readWinningNumbers());
        String rawBonusNumber = inputView.readBonusNumber();
    }
}
