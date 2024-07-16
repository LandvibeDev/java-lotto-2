package service;

import model.Lotto;

import java.util.List;

public class LottoCalculator {

    public int compareWinningNumber(int[] winningNumber, int bonusNumber, Lotto lotto) {
        int count = 0;
        List<Integer> numbers = lotto.getNumber();
        boolean matchingBonusNumber = false;
        for (int j = 0; j < numbers.size(); j++) {
            int number = numbers.get(j);

            for (int k = 0; k < winningNumber.length; k++) {
                if (number == winningNumber[k]) {
                    count++;
                }
            }

            if (number == bonusNumber) {
               matchingBonusNumber= true;
            }
        }

        return count;
    }

    public void updateMatchingResult(int[] matchingResult, int count, boolean matchingBonusNumber) {
        if (count == 6) {
            matchingResult[Enum.MatchingResult.FIRST.getIndex()]++;
        }
        if (count == 5 && matchingBonusNumber) {
            matchingResult[Enum.MatchingResult.SECOND.getIndex()]++;
        }
        if (count == 5 && !matchingBonusNumber) {
            matchingResult[Enum.MatchingResult.THIRD.getIndex()]++;
        }
        if (count == 4) {
            matchingResult[Enum.MatchingResult.FOURTH.getIndex()]++;
        }
        if (count == 3) {
            matchingResult[Enum.MatchingResult.FIFTH.getIndex()]++;
        }
    }

    public int[] matchingWinningNumber(int[] winningNumber, int bonusNumber, List<Lotto> lottos) {
        int[] matchingResult = new int[5];

        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int count = compareWinningNumber(winningNumber, bonusNumber, lotto);
            boolean matchingBonusNumber = lotto.getNumber().contains(bonusNumber);

            updateMatchingResult(matchingResult, count, matchingBonusNumber);
        }

        return matchingResult;
    }

    public int calculateTotalPrizeMoney(int[] matchingResult) {
        int totalPrizeMoney = 0;

        if (matchingResult[Enum.MatchingResult.FIRST.getIndex()] != 0) { // 6개 일치
            totalPrizeMoney += matchingResult[Enum.MatchingResult.FIRST.getIndex()] * Enum.Prize.FIRST.getAmount();
        }
        if (matchingResult[Enum.MatchingResult.SECOND.getIndex()] != 0) { // 5개 + 보너스
            totalPrizeMoney += matchingResult[Enum.MatchingResult.SECOND.getIndex()] * Enum.Prize.FIFTH_BONUS.getAmount();
        }
        if (matchingResult[Enum.MatchingResult.THIRD.getIndex()] != 0) { // 5개 일치
            totalPrizeMoney += matchingResult[Enum.MatchingResult.THIRD.getIndex()] * Enum.Prize.FIFTH.getAmount();
        }
        if (matchingResult[Enum.MatchingResult.FOURTH.getIndex()] != 0) { // 4개 일치
            totalPrizeMoney += matchingResult[Enum.MatchingResult.FOURTH.getIndex()] * Enum.Prize.FOURTH.getAmount();
        }
        if (matchingResult[Enum.MatchingResult.FIFTH.getIndex()] != 0) { // 3개 일치
            totalPrizeMoney += matchingResult[Enum.MatchingResult.FIFTH.getIndex()] * Enum.Prize.THIRD.getAmount();
        }

        return totalPrizeMoney;
    }

    public double calculateProfitRate(int lottoQuantity, int totalPrizeMoney) {
        double cost = lottoQuantity * 1000.0;
        double profitRate = (totalPrizeMoney - cost) / cost * 100.0;

        return profitRate;
    }
}
