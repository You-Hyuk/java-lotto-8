package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generateRandomNumbers(int size, int min, int max) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }

}
