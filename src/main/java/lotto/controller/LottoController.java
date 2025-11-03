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
        long purchaseAmount = getPurchaseAmount();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }

    private long getPurchaseAmount() {
        boolean isFirst = true;

        while (true) {
            try {
                String rawPurchaseAmount = inputView.readPurchaseAmount(isFirst);
                long purchaseAmount = inputParser.parseToLong(rawPurchaseAmount);
                inputValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                isFirst = false;
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        boolean isFirst = true;

        while (true) {
            try {
                String rawWinningNumbers = inputView.readWinningNumbers(isFirst);
                inputValidator.validateRawWinningNumbers(rawWinningNumbers);
                List<Integer> winningNumbers = inputParser.parseToIntegerList(rawWinningNumbers);
                inputValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                isFirst = false;
            }
        }
    }

    private int getBonusNumber() {
        boolean isFirst = true;

        while (true) {
            try {
                String rawBonusNumber = inputView.readBonusNumber(isFirst);
                int bonusNumber = inputParser.parseToInteger(rawBonusNumber);
                inputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                isFirst = false;
            }
        }
    }
}
