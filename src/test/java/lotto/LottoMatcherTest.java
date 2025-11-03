package lotto;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoMatcher;
import org.junit.jupiter.api.Test;

public class LottoMatcherTest {

    @Test
    void 번호_6개가_일치하면_1등_당첨() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 14, 22, 23)));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 14, 22, 23));
        BonusNumber bonusNumber = new BonusNumber(45);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);

        List<Rank> ranks = lottoMatcher.matchAll(lottos);

        assertThat(ranks.getFirst()).isEqualTo(FIRST);
    }
    @Test
    void 번호_5개가_일치하고_보너스_번호가_일치하면_2등_당첨() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 14, 22, 23));
        BonusNumber bonusNumber = new BonusNumber(45);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);

        List<Rank> ranks = lottoMatcher.matchAll(lottos);

        assertThat(ranks.getFirst()).isEqualTo(SECOND);
    }

    @Test
    void 번호_5개가_일치하면_3등_당첨() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 14, 22, 44)));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 14, 22, 23));
        BonusNumber bonusNumber = new BonusNumber(45);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);

        List<Rank> ranks = lottoMatcher.matchAll(lottos);

        assertThat(ranks.getFirst()).isEqualTo(THIRD);
    }

    @Test
    void 번호_4개가_일치하면_4등_당첨() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 14, 21, 44)));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 14, 22, 23));
        BonusNumber bonusNumber = new BonusNumber(45);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);

        List<Rank> ranks = lottoMatcher.matchAll(lottos);

        assertThat(ranks.getFirst()).isEqualTo(FOURTH);
    }

    @Test
    void 번호_3개가_일치하면_5등_당첨() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 15, 21, 44)));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 14, 22, 23));
        BonusNumber bonusNumber = new BonusNumber(45);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);

        List<Rank> ranks = lottoMatcher.matchAll(lottos);

        assertThat(ranks.getFirst()).isEqualTo(FIFTH);
    }

    @Test
    void 번호_2개_이하가_일치하면_꽝() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 10, 11, 12, 13)));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 14, 22, 23));
        BonusNumber bonusNumber = new BonusNumber(45);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);

        List<Rank> ranks = lottoMatcher.matchAll(lottos);

        assertThat(ranks.getFirst()).isEqualTo(NONE);
    }
}
