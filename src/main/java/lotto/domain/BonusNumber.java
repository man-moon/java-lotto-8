package lotto.domain;

import static lotto.config.ErrorMessage.INVALID_BONUS_RANGE;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public boolean isEqual(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_RANGE);
        }
    }
}