package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RandomLotto {
    List<List<Integer>> allLottoNumbers = new ArrayList<>(); //로또 리스트들을 저장하는 리스트
    String[] numbers = new String[6];
    int[] winningCount = new int[8];
    int bonusNumber;

    void getBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        bonusNumber = Integer.parseInt(bonus);
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

    //당첨 번호와 보너스 번호 입력받기
    void insertNumber() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String luckyNumber = Console.readLine();
                numbers = luckyNumber.split(",");
                getBonus();

                //1-45 사이 숫자 아닌 경우 예외처리
                ExceptionOfNumber exceptionOfNumber = new ExceptionOfNumber();
                exceptionOfNumber.exceptionOfNumber(numbers, bonusNumber);
                //6개가 아닌 경우 예외처리
                ExceptionOfLength exceptionOfLength = new ExceptionOfLength();
                exceptionOfLength.exceptionOfLength(numbers);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //당첨 통계 계산
    void winningStatistics(int lottoPrice) {
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
    
    //당첨 내역 출력
    void printStatistics() {
        for (ENUM.WinningEnum winning : ENUM.WinningEnum.values()) {
            System.out.println(winning.getMessage() + winningCount[winning.getIndex()] + "개");
        }
    }
    
    //수익률 출력
    void earningRate(int lottoPrice) {
        int totalPrice = 0;
        for (ENUM.WinningEnum winning : ENUM.WinningEnum.values()) {
            totalPrice += (winning.getPrice() * winningCount[winning.getIndex()]);
        }
        double e = (double) totalPrice / lottoPrice;
        double earningRate = (Math.round(e*1000)/10.0);
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
