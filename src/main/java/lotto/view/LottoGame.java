package lotto.view;

import lotto.model.LottoModel;
import lotto.model.LottoMachineModel;
import lotto.model.WinningResultModel;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private final ConsoleInput consoleInput;
    private final LottoMachineModel lottoMachine;
    private final WinningResultModel winningResult;

    public LottoGame(ConsoleInput consoleInput, LottoMachineModel lottoMachine, WinningResultModel winningResult) {
        this.consoleInput = consoleInput;
        this.lottoMachine = lottoMachine;
        this.winningResult = winningResult;
    }

    public void start() {
        try {
            int purchaseAmount = getPurchaseAmount();
            List<LottoModel> purchasedLottos = generateLottos(purchaseAmount);
            printPurchasedLottos(purchasedLottos);

            Set<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber(winningNumbers);

            checkAndPrintWinningResult(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private int getPurchaseAmount() {
        return consoleInput.getPurchaseAmount();
    }

    private List<LottoModel> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        return lottoMachine.generateLottos(numberOfLottos);
    }

    private void printPurchasedLottos(List<LottoModel> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (LottoModel lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private Set<Integer> getWinningNumbers() {
        return consoleInput.getWinningNumbers();
    }

    private int getBonusNumber(Set<Integer> winningNumbers) {
        return consoleInput.getBonusNumber(winningNumbers);
    }

    private void checkAndPrintWinningResult(List<LottoModel> purchasedLottos, Set<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        winningResult.checkWinning(purchasedLottos, winningNumbers, bonusNumber);
        winningResult.printWinningResult();

        double profitRate = winningResult.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
