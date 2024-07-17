package lotto;

import java.util.List;

public class StatisticsCalculator {
    void produceStatistics(List<List<Integer>> allLottoNumbers, String[] numbers, int[] winningCount, int bonusNumber) {
        //int bonusNumber = insert.getBonusNumber();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (List<Integer> lottoNumbers : allLottoNumbers) {
            int count = 0;
            for (String n : numbers) {
                if (lottoNumbers.contains(Integer.parseInt(n))) {
                    count++;
                }
            }
            if (count == 5 && lottoNumbers.contains(bonusNumber)) {
                winningCount[7]++;
                return;
            }
            winningCount[count]++;
        }
    }
}
