package lotto.enums;

public enum LottoRank {
    FIRST(6, false, 2000000000, "6개 일치"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1500000, "5개 일치"),
    FOURTH(4, false, 50000, "4개 일치"),
    FIFTH(3, false, 5000, "3개 일치"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;
    private final String message;

    LottoRank(int matchCount, boolean bonusRequired, int prize, String message) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    public boolean isBonusRequired() {
        return bonusRequired;
    }

    public static LottoRank getRank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatched) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }
}
