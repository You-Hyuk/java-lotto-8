package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoGame {

    private final Lottos lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoGame(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> calculateResults() {
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos.copyOf()) {
            int matchCount = lotto.countMatchNumbers(winningNumbers);
            boolean bonusMatched = (matchCount == 5) && lotto.contains(bonusNumber);

            LottoRank rank = LottoRank.getRank(matchCount, bonusMatched);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }
}
