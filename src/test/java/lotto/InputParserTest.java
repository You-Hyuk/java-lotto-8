package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    @DisplayName("구입 금액 입력이 숫자가 아닌 경우 예외가 발생한다.")
    public void 구입_금액_입력이_숫자가_아닌_경우_예외가_발생한다() throws Exception {
        //given
        String rawPurchaseAmount = "금액";

        //when && then
        assertThatThrownBy(() -> inputParser.parseToLong(rawPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 중 번호가 숫자가 아닌 경우 예외가 발생한다.")
    public void 당첨_번호_입력_중_번호가_숫자가_아닌_경우_예외가_발생한다() throws Exception {
        //given
        String rawWinningNumbers = "가,나,다,라,마,바";

        //when && then
        assertThatThrownBy(() -> inputParser.parseToInteger(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력이 숫자가 아닌 경우 예외가 발생한다.")
    public void 보너스_번호_입력이_숫자가_아닌_경우_예외가_발생한다() throws Exception {
        //given
        String rawBonusNumber = "보너스";

        //when && then
        assertThatThrownBy(() -> inputParser.parseToInteger(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
