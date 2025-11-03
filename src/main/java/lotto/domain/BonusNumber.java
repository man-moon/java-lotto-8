package lotto.domain;

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
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상, 45 이하여야 합니다.");
        }
    }
}