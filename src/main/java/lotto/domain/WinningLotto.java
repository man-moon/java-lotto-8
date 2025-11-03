package lotto.domain;

import static lotto.config.ErrorMessage.DUPLICATE_WINNING_AND_BONUS;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_AND_BONUS);
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = calculateMatchCount(userLotto);
        boolean isBonusMatched = checkBonusMatch(userLotto);

        return Rank.of(matchCount, isBonusMatched);
    }

    private int calculateMatchCount(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(this.lotto::contains)
                .count();
    }

    private boolean checkBonusMatch(Lotto userLotto) {
        return userLotto.getNumbers().stream()
                .anyMatch(this.bonusNumber::isEqual);
    }
}