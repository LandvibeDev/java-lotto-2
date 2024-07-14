package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInput {
    private final Scanner scan = new Scanner(System.in);

    public int getLottoPrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해주세요");
                int lottoPrice = Integer.parseInt(scan.nextLine());
                if (lottoPrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
                }
                return lottoPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getCollectNum() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = scan.nextLine();
                return splitLottoNum(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNum() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해주세요.");
                int bonusNumber = Integer.parseInt(scan.nextLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitLottoNum(String input) {
        String[] subLottoNum = input.split(",");
        List<Integer> lottoNum = new ArrayList<>();

        for (String element : subLottoNum) {
            try {
                int num = Integer.parseInt(element.trim());
                if (num < 1 || num > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                lottoNum.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 잘못된 형식의 숫자가 입력되었습니다.");
            }
        }
        if (lottoNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return lottoNum;
    }
}
