package lotto.service;

import static lotto.config.ErrorMessage.INVALID_BALANCE_RANGE;
import static lotto.config.ErrorMessage.INVALID_BALANCE_UNIT;
import static lotto.config.LottoConfig.LOTTO_TICKET_PRICE;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MAX_TOTAL_BALANCE;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_TOTAL_BALANCE;
import static lotto.config.LottoConfig.LOTTO_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoPublisher {
    private long totalBalance;

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

    public List<Lotto> publishWithParallelStream() {
        long numTickets = totalBalance / LOTTO_TICKET_PRICE;

        List<Lotto> result = IntStream.range(0, (int) numTickets)
                .parallel()
                .mapToObj(i -> new Lotto(generateRandomNumbers()))
                .collect(Collectors.toList());

        this.totalBalance = 0;
        return result;
    }

    private void validate(long totalBalance) {
        if(totalBalance > MAX_TOTAL_BALANCE || totalBalance < MIN_TOTAL_BALANCE) {
            throw new IllegalArgumentException(INVALID_BALANCE_RANGE);
        }
        if(totalBalance % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_BALANCE_UNIT);
        }
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
                .stream()
                .sorted()
                .toList();
    }
}
