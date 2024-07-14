package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoInput input = new LottoInput();
        LottoGenerate lottoGenerate = new LottoGenerate();
        LottoResultCheck lottoResultCheck = new LottoResultCheck();
        LottoResultPrint lottoResultPrint = new LottoResultPrint();

        int lottoPrice = input.getLottoPrice();
        int lottoNum = lottoPrice / 1000;

        List<Lotto> lottos = lottoGenerate.generateLottos(lottoNum);
        List<Integer> collectNum = input.getCollectNum();
        int bonusNum = input.getBonusNum();

        int[] prizeCounts = lottoResultCheck.checkCollectNum(lottos, collectNum, bonusNum);
        lottoResultPrint.printResult(prizeCounts, lottoPrice);
    }
}
