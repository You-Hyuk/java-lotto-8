package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.enums.LottoRank;

public class LottoGameService {

    public Map<LottoRank, Integer> generateLottoGame(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoGame lottoGame = new LottoGame(lottos, winningNumbers, bonusNumber);
        return lottoGame.calculateResults();
    }
}
