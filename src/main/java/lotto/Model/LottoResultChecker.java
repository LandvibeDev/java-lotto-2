package lotto.Model;

import java.util.List;

public class LottoResultChecker {
    public int[] checkCorrectNum(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] prizeCnt = new int[5];
        for (Lotto lotto : lottos) {
            int correctCnt = 0;
            boolean bonusCorrect = false;

            for (Integer number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    correctCnt++;
                }
            }

            if (lotto.getNumbers().contains(bonusNumber)) {
                bonusCorrect = true;
            }

            if (correctCnt == 6) {
                prizeCnt[4]++;
            }

            if (correctCnt == 5 && bonusCorrect) {
                prizeCnt[3]++;
            }

            if (correctCnt == 5 && !bonusCorrect) {
                prizeCnt[2]++;
            }

            if (correctCnt == 4) {
                prizeCnt[1]++;
            }

            if (correctCnt == 3) {
                prizeCnt[0]++;
            }
        }
        return prizeCnt;
    }
}
