package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static List<Integer> generateRandomNumbers(int size, int min, int max) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }

}
