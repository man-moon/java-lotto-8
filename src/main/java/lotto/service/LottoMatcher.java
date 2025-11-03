package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoMatcher {
    private final WinningLotto winningLotto;

    public LottoMatcher(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Rank> matchAll(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }
}