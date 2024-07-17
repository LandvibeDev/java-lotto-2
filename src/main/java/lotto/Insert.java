package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Insert {
    String[] numbers = new String[6];
    int bonusNumber;

    //구입 금액 입력
    void insertPrice(int lottoPrice) {
        Exception exceptionOfPrice = new Exception();
        exceptionOfPrice.ExceptionOfPrice(lottoPrice);
        System.out.println(lottoPrice / 1000 + "개를 구매했습니다.");
    }

    String[] insertNumber() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String luckyNumber = Console.readLine();
                numbers = luckyNumber.split(",");

                //1-45 사이 숫자 아닌 경우 예외처리
                Exception exceptionOfNumber = new Exception();
                exceptionOfNumber.exceptionOfNumber(numbers);
                //6개가 아닌 경우 예외처리
                Exception exceptionOfLength = new Exception();
                exceptionOfLength.exceptionOfLength(numbers);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numbers;
    }

    void insertBonus() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonus = Console.readLine();
                bonusNumber = Integer.parseInt(bonus);

                Exception exceptionOfBonus = new Exception();
                exceptionOfBonus.exceptionOfBonus(bonusNumber);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    int getBonusNumber(){
        return bonusNumber;
    }
}