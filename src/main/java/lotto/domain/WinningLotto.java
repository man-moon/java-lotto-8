package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복일 수 없습니다.");
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