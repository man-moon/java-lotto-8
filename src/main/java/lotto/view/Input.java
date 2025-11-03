package lotto.view;

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
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 \"숫자,숫자,숫자,숫자,숫자,숫자\" 형식이어야 합니다.");
        }
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine().trim();

        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
