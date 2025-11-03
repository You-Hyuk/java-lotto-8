package lotto;

import lotto.domain.Lottos;
import lotto.service.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("구입 금액 입력에 따른 개수 만큼 로또가 발행된다.")
    public void 구입_금액_입력에_따른_개수_만큼_로또가_발행된다() throws Exception {
        //given
        int amount = 10000;
        
        //when
        int count = lottoGenerator.calculateLottoCount(amount);
        Lottos lottos = lottoGenerator.issueLottos(count);

        //then
        Assertions.assertThat(lottos.copyOf().size()).isEqualTo(10);
    }
}
