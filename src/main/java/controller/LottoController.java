package controller;

import model.Lotto;
import service.LottoCalculator;
import service.LottoGenerator;
import view.UserView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final UserView userView;
    private final LottoCalculator lottoCalculator;
    private final LottoGenerator lottoGenerator;

    public LottoController(UserView userView, LottoCalculator lottoCalculator, LottoGenerator lottoGenerator) {
        this.userView = userView;
        this.lottoCalculator = lottoCalculator;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        userView.printStartMessage(); // 시작 메시지 출력

        // 사용자로부터 구매할 로또 개수 입력받기
        int lottoQuantity = userView.getLottoQuantity();

        // 구매한 로또 리스트 생성
        List<Lotto> lottos = lottoGenerator.generateLottos(lottoQuantity);
        userView.printGeneratedLotto(lottos); // 생성된 로또 번호 출력

        // 당첨 번호와 보너스 번호 입력 받기
        int[] winningNumbers = userView.getLotteryWinningNumber();
        int bonusNumber = userView.getBonusNumber();

        // 맞춘 각 등수별 개수 계산
        int[] matchingCounts = lottoCalculator.matchingWinningNumber(winningNumbers, bonusNumber, lottos);

        // 총 상금 계산
        int totalPrize = lottoCalculator.calculateTotalPrizeMoney(matchingCounts);

        // 수익률 계산
        double profitRate = lottoCalculator.calculateProfitRate(lottoQuantity, totalPrize);

        // 결과 출력
        userView.printResult(matchingCounts, profitRate);
    }


}
