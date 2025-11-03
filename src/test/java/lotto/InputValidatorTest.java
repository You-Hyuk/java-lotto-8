package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.util.InputParser;
import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("구입 금액 입력이 1000원 단위로 나누어 떨어지는 숫자인 경우 성공한다.")
    public void 구입_금액_입력이_1000원_단위로_나누어_떨어지는_숫자인_경우_성공한다() throws Exception {
        //given
        long purchaseAmount = 10000;

        //when && //then
        assertDoesNotThrow(() ->{
            InputValidator.validatePurchaseAmount(purchaseAmount);
        });
    }
    
    @Test
    @DisplayName("당첨 번호 입력이 쉼표(,)로 구분된 1 ~ 45 사이의 6개의 숫자인 경우 성공한다.")
    public void 당첨_번호_입력이_쉼표로_구분된_1부터_45_사이의_6개의_숫자인_경우_성공한다() throws Exception {
        //given
        String rawWinningNumbers = "1,2,3,4,5,6";
        
        //when && then
        assertDoesNotThrow(() -> {
            InputValidator.validateRawWinningNumbers(rawWinningNumbers);
            List<Integer> winningNumbers = InputParser.parseToIntegerList(rawWinningNumbers);
            InputValidator.validateWinningNumbers(winningNumbers);
        });
    }
    
    @Test
    @DisplayName("보너스 번호 입력이 숫자이며 1 ~ 45 사이의 숫자인 경우 성공한다.")
    public void 보너스_번호_입력이_숫자이며_1부터_45_사이의_숫자인_경우_성공한다() throws Exception {
        //given
        int bonusNumber = 1;
        
        //when && then
        assertDoesNotThrow(() -> {
            InputValidator.validateBonusNumber(bonusNumber);
        });
    }

    @Test
    @DisplayName("구입 금액 입력이 1000원 단위로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    public void 구입_금액_입력이_1000원_단위로_나누어_떨어지지_않는_경우_예외가_발생한다() throws Exception {
        //given
        long purchaseAmount = 12345;

        //when && then
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 중 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    public void 당첨_번호_입력_중_번호가_1부터_45_사이의_숫자가_아닌_경우_예외가_발생한다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        //when && then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 중 번호가 6개가 아닌 경우 예외가 발생한다.")
    public void 당첨_번호_입력_중_번호가_6개가_아닌_경우_예외가_발생한다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //when && then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력이 쉼표(,)를 기준으로 구분되지 않는 경우 예외가 발생한다.")
    public void 당첨_번호_입력이_쉼표를_기준으로_구분되지_않는_경우_예외가_발생한다() throws Exception {
        //given
        String rawWinningNumbers = "1:2:3:4:5:6";

        //when && then
        assertThatThrownBy(() -> {
            List<Integer> winningNumbers = InputParser.parseToIntegerList(rawWinningNumbers);
            InputValidator.validateWinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력이 쉼표(,)로 끝나는 경우 예외가 발생한다.")
    public void 당첨_번호_입력이_쉼표로_끝나는_경우_예외가_발생한다() throws Exception {
        //given
        String rawWinningNumbers = "1,2,3,4,5,6,";

        //when && then
        assertThatThrownBy(() -> InputValidator.validateRawWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 중 숫자들이 중복되는 경우 예외가 발생한다.")
    public void 당첨_번호_입력_중_숫자들이_중복되는_경우_예외가_발생한다() throws Exception {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);

        //when && then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("보너스 번호 입력이 1 ~ 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    public void 보너스_번호_입력이_1부터_45_사이의_숫자가_아닌_경우_예외가_발생한다() throws Exception {
        //given
        int bonusNumber = 0;

        //when && then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
