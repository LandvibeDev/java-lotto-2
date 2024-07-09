package lotto;

import java.util.List;
import java.util.Set;

public class Application {
    private final ConsoleInput consoleInput;
    private final LottoMachine lottoMachine;
    private final WinningResult winningResult;

    public Application(ConsoleInput consoleInput, LottoMachine lottoMachine, WinningResult winningResult) {
        this.consoleInput = consoleInput;
        this.lottoMachine = lottoMachine;
        this.winningResult = winningResult;
    }

    public void run() {
        try {
            int purchaseAmount = consoleInput.getPurchaseAmount();
            int numberOfLottos = purchaseAmount / 1000;

            List<Lotto> purchasedLottos = lottoMachine.generateLottos(numberOfLottos);
            printPurchasedLottos(purchasedLottos);

            Set<Integer> winningNumbers = consoleInput.getWinningNumbers();
            int bonusNumber = consoleInput.getBonusNumber(winningNumbers);

            winningResult.checkWinning(purchasedLottos, winningNumbers, bonusNumber);
            winningResult.printWinningResult();

            double profitRate = winningResult.calculateProfitRate(purchaseAmount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Application lottoGame = appConfig.application();
        lottoGame.run();
    }
}
