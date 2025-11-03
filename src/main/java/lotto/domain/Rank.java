package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L);

    private final int matchedCount;
    private final long prize;

    Rank(int matchedCount, long prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static Rank of(int matchedCount, boolean isBonusMatched) {
        if(matchedCount == 6) return FIRST;
        if(matchedCount == 5 && isBonusMatched) return SECOND;
        if(matchedCount == 5) return THIRD;
        if(matchedCount == 4) return FOURTH;
        if(matchedCount == 3) return FIFTH;
        return NONE;
    }

    public long getPrize() {
        return prize;
    }
}