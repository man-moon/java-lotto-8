package lotto;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.service.LottoMatcher;
import lotto.service.LottoPublisher;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        List<Lotto> userLottos = purchaseLottos(input, output);

        Lotto winningNumbers = getWinningNumbers(input);
        WinningLotto winningLotto = createWinningLotto(input, winningNumbers);

        LottoResult result = calculateResults(userLottos, winningLotto);

        displayResults(output, result);
    }

    private static List<Lotto> purchaseLottos(Input input, Output output) {
        while (true) {
            try {
                long buyPrice = input.getBuyPrice();

                LottoPublisher lottoPublisher = new LottoPublisher(buyPrice);
                List<Lotto> userLottos = lottoPublisher.publish();

                output.printBuyResult(userLottos);
                return userLottos;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto getWinningNumbers(Input input) {
        while (true) {
            try {
                return new Lotto(input.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningLotto createWinningLotto(Input input, Lotto winningNumbers) {
        while (true) {
            try {
                BonusNumber bonusNumber = new BonusNumber(input.getBonusNumber());
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static LottoResult calculateResults(List<Lotto> userLottos, WinningLotto winningLotto) {
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);
        return lottoMatcher.matchAll(userLottos);
    }

    private static void displayResults(Output output, LottoResult result) {
        output.printResult(result);
    }
}