package lotto;
import java.util.Scanner;
//로또 금액 입력받기
public class Input_Lotto_count {

    int Input() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        if(number%1000!=0){
            throw new IllegalArgumentException();
        }
        return number/1000;
    }
}
