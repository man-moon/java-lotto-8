package lotto.domain;

import static lotto.config.LottoConfig.FIFTH_MATCH_COUNT;
import static lotto.config.LottoConfig.FIFTH_PRIZE;
import static lotto.config.LottoConfig.FIRST_MATCH_COUNT;
import static lotto.config.LottoConfig.FIRST_PRIZE;
import static lotto.config.LottoConfig.FOURTH_MATCH_COUNT;
import static lotto.config.LottoConfig.FOURTH_PRIZE;
import static lotto.config.LottoConfig.SECOND_MATCH_COUNT;
import static lotto.config.LottoConfig.SECOND_PRIZE;
import static lotto.config.LottoConfig.THIRD_MATCH_COUNT;
import static lotto.config.LottoConfig.THIRD_PRIZE;

import java.util.List;

public enum Rank {
    FIFTH(FIFTH_MATCH_COUNT, FIFTH_PRIZE, "3개 일치 (5,000원) - %d개"),
    FOURTH(FOURTH_MATCH_COUNT, FOURTH_PRIZE, "4개 일치 (50,000원) - %d개"),
    THIRD(THIRD_MATCH_COUNT, THIRD_PRIZE, "5개 일치 (1,500,000원) - %d개"),
    SECOND(SECOND_MATCH_COUNT, SECOND_PRIZE, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(FIRST_MATCH_COUNT, FIRST_PRIZE, "6개 일치 (2,000,000,000원) - %d개"),
    NONE(0, 0L, "");

    private final int matchedCount;
    private final long prize;
    private final String message;

    Rank(int matchedCount, long prize, String message) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.message = message;
    }

    public static List<Rank> getDisplayRanks() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public String getMessage(int count) {
        return String.format(message, count);
    }

    public static Rank of(int matchedCount, boolean isBonusMatched) {
        if (matchedCount == FIRST_MATCH_COUNT) return FIRST;
        if (matchedCount == SECOND_MATCH_COUNT && isBonusMatched) return SECOND;
        if (matchedCount == THIRD_MATCH_COUNT) return THIRD;
        if (matchedCount == FOURTH_MATCH_COUNT) return FOURTH;
        if (matchedCount == FIFTH_MATCH_COUNT) return FIFTH;
        return NONE;
    }

    public long getPrize() {
        return prize;
    }
}