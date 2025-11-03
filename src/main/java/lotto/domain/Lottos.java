package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public List<Lotto> copyOf() {
        return lottos.stream()
                .map(lotto -> new Lotto(new ArrayList<>(lotto.getNumbers())))
                .collect(Collectors.toUnmodifiableList());
    }
}
