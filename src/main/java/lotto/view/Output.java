package lotto.view;

import static lotto.domain.Rank.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class Output {

    public void printBuyResult(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto l : lottos) {
            List<Integer> numbers = l.getNumbers();
            String output = String.join(", ", numbers.toString());
            System.out.println(output);
        }
    }

    public void printResult(LottoResult result) {
        System.out.println("""
                당첨 통계
                ---"""
        );
        for (Rank rank : Rank.getDisplayRanks()) {
            System.out.println(
                    rank.getMessage(result.getRankCounts(rank))
            );
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.getProfitRate());
    }
}
