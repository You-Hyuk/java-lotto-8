package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.enums.LottoRank;
import lotto.service.LottoGameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class LottoGameServiceTest {

    private final LottoGameService lottoGameService = new LottoGameService();

    @Test
    @DisplayName("로또 번호와 당첨 번호가 1개 일치하는 경우 당첨되지 않는다.")
    public void 로또_번호와_당첨_번호가_1개_일치하는_경우_당첨되지_않는다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 7, 8, 9, 10, 11));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.NONE))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 2개 일치하는 경우 당첨되지 않는다.")
    public void 로또_번호와_당첨_번호가_2개_일치하는_경우_당첨되지_않는다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.NONE))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 3개 일치하는 경우 5등이 당첨된다.")
    public void 로또_번호와_당첨_번호가_3개_일치하는_경우_5등이_당첨된다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 10, 11));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.FIFTH))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 4개 일치하는 경우 4등이 당첨된다.")
    public void 로또_번호와_당첨_번호가_4개_일치하는_경우_4등이_당첨된다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.FOURTH))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 5개 일치하며 보너스 번호가 일치하지 않는 경우 3등이 당첨된다.")
    public void 로또_번호와_당첨_번호가_5개_일치하며_보너스_번호가_일치하지_않는_경우_3등이_당첨된다() throws Exception
    {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.THIRD))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 5개 일치하며 보너스 번호가 일치하는 경우 2등이 당첨된다.")
    public void 로또_번호와_당첨_번호가_5개_일치하며_보너스_번호가_일치하는_경우_2등이_당첨된다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 11;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.SECOND))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 6개 일치하는 경우 1등이 당첨된다.")
    public void 로또_번호와_당첨_번호가_6개_일치하는_경우_1등이_당첨된다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoRankMap.get(LottoRank.FIRST))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률을 계산한다.")
    public void 총_수익률을_계산한다() throws Exception {
        //given
        int purchaseAmount = 1000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lottos lottos = new Lottos(List.of(lotto));
        int bonusNumber = 12;

        //when
        Map<LottoRank, Integer> lottoRankMap = lottoGameService.generateLottoGame(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(lottoGameService.calculateProfitRate(purchaseAmount, lottoRankMap))
                .isEqualTo(500.0);
    }

}
