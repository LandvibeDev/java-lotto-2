package lotto;

import camp.nextstep.edu.missionutils.Console;
//로또 금액 입력받는 클래스
public class Input_Lotto_count {

    int Input() {

        while(true) {
            try{
                System.out.println("구입금액을 입력해 주세요");
                String number = Console.readLine();
                int intNumber = Integer.parseInt(number);
            if (intNumber % 1000 != 0) { //예외처리
                throw new IllegalArgumentException();
            }
            return intNumber / 1000;
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR]구입 금액은 1000의 배수여야 하고, 정수여야 합니다.");
            }
        }
    }
}
