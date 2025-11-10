package lotto;

import static lotto.config.LottoConfig.LOTTO_NUMBER_SIZE;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTimeTest {

    final int MAX_NUMBER = 100_000_000;

    // 1분 소요
    @Test
    void 로또번호_1억건_생성에_걸리는_시간() {
        long before = System.nanoTime();
        for (int i = 0; i < MAX_NUMBER; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
                    .stream()
                    .sorted()
                    .toList();
        }
        long after = System.nanoTime();
        long durationNanos = after - before;
        double durationSeconds = durationNanos / 1_000_000_000.0;
        System.out.println(durationSeconds);
    }

    // 50초 소요
    @Test
    void 로또번호_1억건_생성에_걸리는_시간_정렬_제외() {
        long before = System.nanoTime();
        for (int i = 0; i < MAX_NUMBER; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
                    .stream()
                    .toList();
        }
        long after = System.nanoTime();
        long durationNanos = after - before;
        double durationSeconds = durationNanos / 1_000_000_000.0;
        System.out.println(durationSeconds);
    }

    // 48초
    @Test
    void 로또번호_1억건_생성에_걸리는_시간_정렬_리스트반환_제외() {
        long before = System.nanoTime();
        for (int i = 0; i < MAX_NUMBER; i++) {
            CustomRandom.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
        }
        long after = System.nanoTime();
        long durationNanos = after - before;
        double durationSeconds = durationNanos / 1_000_000_000.0;
        System.out.println(durationSeconds);
    }

    // 10ms
    @Test
    void 그냥_연산_1억번_걸리는_시간() {
        long before = System.nanoTime();
        for (int i = 0; i < MAX_NUMBER; i++) {
            int a = 1000 + i;
        }
        long after = System.nanoTime();
        long durationNanos = after - before;
        double durationSeconds = durationNanos / 1_000_000_000.0;
        System.out.println(durationSeconds);
    }

    @Test
    void 병렬_걸리는_시간() {
        long before = System.nanoTime();
        IntStream.range(0, MAX_NUMBER)
                .parallel()
                .forEach(i -> {
                    CustomRandom.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
                });
        long after = System.nanoTime();
        long durationNanos = after - before;
        double durationSeconds = durationNanos / 1_000_000_000.0;
        System.out.println(durationSeconds);
    }
}
