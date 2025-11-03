package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lottos;
import lotto.enums.LottoRank;
import lotto.enums.OutputPrompt;

public class OutputView {

    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.println(count + OutputPrompt.PURCHASE_COUNT.getMessage());
    }

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printLottoResult(Map<LottoRank, Integer> lottoRankMap) {
        System.out.println();
        System.out.println(OutputPrompt.LOTTO_RESULT.getMessage());
        System.out.println(formatLottoRankMap(lottoRankMap));
    }

    public void printProfitRate(double profitRate) {
        String formattedProfitRate = formatProfitRate(profitRate);
        System.out.printf(OutputPrompt.PROFIT_RATE.getMessage(), formattedProfitRate);
    }

    private String formatLottoRankMap(Map<LottoRank, Integer> lottoRankMap) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .sorted(Comparator
                        .comparingInt(LottoRank::getMatchCount)
                        .thenComparing(LottoRank::isBonusRequired))
                .map(rank -> formatRankLine(rank, lottoRankMap.getOrDefault(rank, 0)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatRankLine(LottoRank rank, int count) {
        return String.format(
                "%s (%s원) - %d개",
                rank.getMessage(),
                formatPrize(rank.getPrize()),
                count
        );
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    private String formatProfitRate(double profitRate) {
        return new DecimalFormat("#,##0.0").format(new BigDecimal(profitRate));
    }
}
