package lotto;

import java.util.List;

public class LottoResultCheck {
    public int[] checkCollectNum(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] prizeCnt = new int[5];
        for (Lotto lotto : lottos) {
            int collectCnt = 0;
            boolean bonusCollect = false;

            for (Integer number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    collectCnt++;
                }
            }

            if (lotto.getNumbers().contains(bonusNumber)) {
                bonusCollect = true;
            }

            if (collectCnt == 6) {
                prizeCnt[4]++;
            } else if (collectCnt == 5 && bonusCollect) {
                prizeCnt[3]++;
            } else if (collectCnt == 5) {
                prizeCnt[2]++;
            } else if (collectCnt == 4) {
                prizeCnt[1]++;
            } else if (collectCnt == 3) {
                prizeCnt[0]++;
            }
        }
        return prizeCnt;
    }
}
