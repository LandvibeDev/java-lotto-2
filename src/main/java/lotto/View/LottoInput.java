package lotto.View;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInput {
    private final Console console = System.console();
    private final Scanner scanner;

    public LottoInput() {
        if (console == null) {
            scanner = new Scanner(System.in);
        } else {
            scanner = null;
        }
    }

    static final int MIN_LOTTO_NUMBER = LottoNumberRange.MIN_NUMBER.getValue();
    static final int MAX_LOTTO_NUMBER = LottoNumberRange.MAX_NUMBER.getValue();
    static final int LOTTO_NUMBER_COUNT = 6;
    static final int LOTTO_PRICE_UNIT = 1000;

    public enum LottoNumberRange {
        MIN_NUMBER(1),
        MAX_NUMBER(45);

        final int value;

        LottoNumberRange(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public int getLottoPrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해주세요.");
                String input;
                if (console != null) {
                    input = console.readLine();
                } else {
                    input = scanner.nextLine();
                }
                int lottoPrice = Integer.parseInt(input);
                if (lottoPrice % LOTTO_PRICE_UNIT != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE_UNIT + "원 단위로 입력해야 합니다.");
                }
                return lottoPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getCorrectNum() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input;
                if (console != null) {
                    input = console.readLine();
                } else {
                    input = scanner.nextLine();
                }
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
                String input;
                if (console != null) {
                    input = console.readLine();
                } else {
                    input = scanner.nextLine();
                }
                int bonusNumber = Integer.parseInt(input);
                if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitLottoNum(String input) {
        String[] splitLottoNumList = input.split(",");
        List<Integer> lottoNum = new ArrayList<>();

        for (String splitLottoNum : splitLottoNumList) {
            try {
                int num = Integer.parseInt(splitLottoNum.trim());
                if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
                }
                lottoNum.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 잘못된 형식의 숫자가 입력되었습니다.");
            }
        }
        if (lottoNum.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
        return lottoNum;
    }
}
