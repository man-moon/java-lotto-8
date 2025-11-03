package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoMatcher {
    private final WinningLotto winningLotto;

    public LottoMatcher(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoResult matchAll(List<Lotto> userLottos) {
        List<Rank> ranks = userLottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());

        return new LottoResult(ranks);
    }
}