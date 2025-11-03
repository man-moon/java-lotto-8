package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int getBuyPrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String buyPriceInput = Console.readLine().trim();

            try {
                return Integer.parseInt(buyPriceInput);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구매 금액은 숫자여야 합니다.");
            }
        }
    }
}
