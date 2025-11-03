package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generateRandomNumbers(int size, int min, int max) {
        List<Integer> randomNumbers;

        do {
            randomNumbers = new ArrayList<>();
            for (int count = 0; count < size; count++) {
                randomNumbers.add(generateRandomNumber(min, max));
            }
        } while (checkDuplicateNumber(randomNumbers));

        return randomNumbers;
    }

    private int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    private boolean checkDuplicateNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        return distinctCount != numbers.size();
    }
}
