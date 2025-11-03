package lotto.view;

import lotto.domain.Lottos;
import lotto.enums.OutputPrompt;

public class OutputView {

    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.println(count + OutputPrompt.PURCHASE_COUNT.getMessage());
    }

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }
}
