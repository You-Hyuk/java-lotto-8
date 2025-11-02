package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputPrompt;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println(InputPrompt.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }
}
