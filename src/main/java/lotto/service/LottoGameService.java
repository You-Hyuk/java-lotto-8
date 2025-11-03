package lotto.service;

import java.util.Arrays;
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

    public double calculateProfitRate(long purchaseAmount, Map<LottoRank, Integer> lottoRankMap) {
        long totalPrize = calculateTotalPrize(lottoRankMap);
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }

    public long calculateTotalPrize(Map<LottoRank, Integer> lottoRankMap) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .mapToLong(lottoRank -> (long) lottoRank.getPrize() * lottoRankMap.getOrDefault(lottoRank, 0))
                .sum();
    }
}
