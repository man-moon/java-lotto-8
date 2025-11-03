package lotto;

import static lotto.service.LottoPublisher.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.service.LottoPublisher;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class LottoPublisherTest {

    private final long NEGATIVE_BALANCE = -1000L;
    private final long EXCEED_MAX_BALANCE = MAX_TOTAL_BALANCE + 1L;
    private final long BUY_AMOUNT = 5000L;

    @Test
    void 구매_금액이_0원일_때_정상적으로_생성된다() {
        assertThatCode(() -> new LottoPublisher(MIN_TOTAL_BALANCE))
                .doesNotThrowAnyException();
    }

    @Test
    void 구매_금액이_1000억원일_때_정상적으로_생성된다() {
        assertThatCode(() -> new LottoPublisher(MAX_TOTAL_BALANCE))
                .doesNotThrowAnyException();
    }

    @Test
    void 구매_금액이_0원이면_0개가_발행된다() {
        LottoPublisher lottoPublisher = new LottoPublisher(MIN_TOTAL_BALANCE);

        List<Lotto> lottos = lottoPublisher.publish();

        assertThat(lottos.size()).isEqualTo(0);
    }

    @Test
    void 구매_금액이_10억이면_1백만개가_발행된다() {
        LottoPublisher lottoPublisher = new LottoPublisher(MAX_TOTAL_BALANCE);

        List<Lotto> lottos = lottoPublisher.publish();

        assertThat(lottos.size()).isEqualTo(1_000_000L);
    }

    @Test
    void 구매_금액을_1000으로_나눈만큼의_개수가_발행된다() {
        LottoPublisher lottoPublisher = new LottoPublisher(BUY_AMOUNT);
        long amount = BUY_AMOUNT / LOTTO_TICKET_PRICE;

        List<Lotto> lottos = lottoPublisher.publish();

        assertThat(lottos.size()).isEqualTo(amount);
    }

    @Test
    void 구매_금액이_0원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPublisher(NEGATIVE_BALANCE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액이_10억_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPublisher(EXCEED_MAX_BALANCE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
