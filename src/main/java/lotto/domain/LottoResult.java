package lotto.domain;

import static lotto.config.LottoConfig.LOTTO_TICKET_PRICE;
import static lotto.config.LottoConfig.PROFIT_RATE_MULTIPLIER;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;
    private final double profitRate;

    public LottoResult(List<Rank> ranks) {
        this.rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            int currentCount = rankCounts.getOrDefault(rank, 0);
            rankCounts.put(rank, currentCount + 1);
        }

        long totalPrize = ranks.stream()
                .mapToLong(Rank::getPrize)
                .sum();
        long totalCost = ranks.size() * LOTTO_TICKET_PRICE;
        this.profitRate = (double) totalPrize / totalCost * PROFIT_RATE_MULTIPLIER;
    }

    public int getRankCounts(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
