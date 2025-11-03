package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputPrompt;

public class InputView {

    public String readPurchaseAmount(boolean showPrompt) {
        if (showPrompt) {
            System.out.println(InputPrompt.PURCHASE_AMOUNT.getMessage());
        }

        return Console.readLine();
    }

    public String readWinningNumbers(boolean showPrompt) {
        if (showPrompt) {
            System.out.println();
            System.out.println(InputPrompt.WINNING_NUMBERS.getMessage());
        }

        return Console.readLine();
    }

    public String readBonusNumber(boolean showPrompt) {
        if (showPrompt) {
            System.out.println();
            System.out.println(InputPrompt.BONUS_NUMBERS.getMessage());
        }

        return Console.readLine();
    }
}
