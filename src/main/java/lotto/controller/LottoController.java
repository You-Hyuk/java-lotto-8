package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
    }
}
