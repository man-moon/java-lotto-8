package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoPublisher {
    private long totalBalance;
    public static final long LOTTO_TICKET_PRICE = 1_000L;
    public static final long MIN_TOTAL_BALANCE = 0L;
    public static final long MAX_TOTAL_BALANCE = 1_000_000_000L;

    public LottoPublisher(long totalBalance) {
        validate(totalBalance);
        this.totalBalance = totalBalance;
    }

    public List<Lotto> publish() {
        long numTickets = totalBalance / LOTTO_TICKET_PRICE;
        List<Lotto> result = new ArrayList<>((int)numTickets);

        for (int i = 0; i < numTickets; i++) {
            List<Integer> numbers = generateRandomNumbers();
            result.add(new Lotto(numbers));
        }
        this.totalBalance = 0;

        return result;
    }

    private void validate(long totalBalance) {
        if(totalBalance > MAX_TOTAL_BALANCE || totalBalance < MIN_TOTAL_BALANCE) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0원 이상 10억 이하여야 합니다.");
        }
        if(totalBalance % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
    }
}
