package lotto.controller;

import java.util.List;
import lotto.domain.Lottos;
import lotto.service.InputParser;
import lotto.service.LottoGenerator;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        long purchaseAmount = getPurchaseAmount();
        int count = lottoGenerator.calculateLottoCount(purchaseAmount);
        outputView.printPurchaseCount(count);
        Lottos lottos = lottoGenerator.issueLottos(count);
        outputView.printLottoNumbers(lottos);
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
