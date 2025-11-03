package lotto.view;

import static lotto.config.ErrorMessage.INVALID_BALANCE_FORMAT;
import static lotto.config.ErrorMessage.INVALID_BONUS_FORMAT;
import static lotto.config.ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class Input {
    public long getBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String buyPriceInput = Console.readLine().trim();

        try {
            return Long.parseLong(buyPriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BALANCE_FORMAT);
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine().trim();

        try {
            return Stream.of(winningNumbersInput.split(",", -1))
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT);
        }
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine().trim();

        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_FORMAT);
        }
    }
}
