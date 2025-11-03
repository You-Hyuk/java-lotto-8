package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.enums.LottoRank;
import lotto.util.InputParser;
import lotto.service.LottoGameService;
import lotto.service.LottoGenerator;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoGameService lottoGameService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoGenerator lottoGenerator,
            LottoGameService lottoGameService
    )
    {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        long purchaseAmount = getPurchaseAmount();
        int count = lottoGenerator.calculateLottoCount(purchaseAmount);
        outputView.printPurchaseCount(count);
        Lottos lottos = lottoGenerator.issueLottos(count);
        outputView.printLottoNumbers(lottos);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        Map<LottoRank, Integer> lottoRankMap =
                lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);
        outputView.printLottoResult(lottoRankMap);
        double profitRate = lottoGameService.calculateProfitRate(purchaseAmount, lottoRankMap);
        outputView.printProfitRate(profitRate);
    }

    private long getPurchaseAmount() {
        boolean isFirst = true;

        while (true) {
            try {
                String rawPurchaseAmount = inputView.readPurchaseAmount(isFirst);
                long purchaseAmount = InputParser.parseToLong(rawPurchaseAmount);
                InputValidator.validatePurchaseAmount(purchaseAmount);
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
                InputValidator.validateRawWinningNumbers(rawWinningNumbers);
                List<Integer> winningNumbers = InputParser.parseToIntegerList(rawWinningNumbers);
                InputValidator.validateWinningNumbers(winningNumbers);
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
                int bonusNumber = InputParser.parseToInteger(rawBonusNumber);
                InputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                isFirst = false;
            }
        }
    }
}
