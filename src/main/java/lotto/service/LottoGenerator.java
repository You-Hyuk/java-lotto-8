package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.enums.LottoConstants;

public class LottoGenerator {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Lottos issueLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(randomNumberGenerator.generateRandomNumbers(
                    LottoConstants.LOTTO_NUMBER_COUNT.getValue(),
                    LottoConstants.MIN_NUMBER.getValue(),
                    LottoConstants.MAX_NUMBER.getValue()
            )));
        }
        return new Lottos(lottos);
    }

    public int calculateLottoCount(long purchaseAmount) {
        return (int) (purchaseAmount / LottoConstants.LOTTO_PRICE.getValue());
    }
}
