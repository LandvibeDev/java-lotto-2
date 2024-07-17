package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomLotto {
    List<List<Integer>> allLottoNumbers = new ArrayList<>(); //로또 리스트들을 저장하는 리스트
    String[] numbers = new String[6];
    int[] winningCount = new int[8];
    Insert insert = new Insert();

    void setBonus() {
        insert.insertBonus();
    }

    // 구입 금액만큼 로또 번호를 랜덤으로 출력
    void randomLotto(int lottoPrice) {
        for (int i = 0; i < lottoPrice / 1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers); //list 가 유효한지 검증
            Collections.sort(lottoNumbers); //오름차순 정렬
            allLottoNumbers.add(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    void insertNumber() {
        numbers = insert.insertNumber();
    }
    
    //당첨 통계 계산
    void produceStatistics() {
        int bonusNumber = insert.getBonusNumber();
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.produceStatistics(allLottoNumbers, numbers, winningCount, bonusNumber);
    }

    //당첨 내역과 수익률
    void printAll(int lottoPrice) {
        Print print = new Print();
        print.printStatistics(winningCount);
        print.printEarningRate(winningCount, lottoPrice);
    }
}
