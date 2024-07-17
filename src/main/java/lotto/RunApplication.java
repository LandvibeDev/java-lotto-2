package lotto;

import camp.nextstep.edu.missionutils.Console;
public class RunApplication {
    void run() {
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String price = Console.readLine();
                int lottoPrice = Integer.parseInt(price);

                //로또 구입 금액 입력
                Insert insert = new Insert();
                insert.insertPrice(lottoPrice);

                //구입 금액만큼 랜덤 로또 번호 출력
                RandomLotto randomLotto = new RandomLotto();
                randomLotto.randomLotto(lottoPrice);

                //당첨 번호, 보너스 번호 입력
                randomLotto.insertNumber();
                randomLotto.setBonus();

                //당첨 통계
                randomLotto.produceStatistics();
                //당첨 내역과 수익률 출력
                randomLotto.printAll(lottoPrice);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
