package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoNumGenerater;
import lotto.Model.LottoResultChecker;
import lotto.View.LottoInput;
import lotto.View.LottoResultPrinter;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoInput input = new LottoInput();
        LottoNumGenerater lottoGenerate = new LottoNumGenerater();
        LottoResultChecker lottoResultCheck = new LottoResultChecker();
        LottoResultPrinter lottoResultPrint = new LottoResultPrinter();

        int lottoPrice = input.getLottoPrice();
        int lottoNum = lottoPrice / 1000;

        List<Lotto> lottos = lottoGenerate.generateLottos(lottoNum);
        List<Integer> correctNum = input.getCorrectNum();
        int bonusNum = input.getBonusNum();

        int[] prizeCounts = lottoResultCheck.checkCorrectNum(lottos, correctNum, bonusNum);
        lottoResultPrint.printResult(prizeCounts, lottoPrice);
    }
}
