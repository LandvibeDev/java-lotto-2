package lotto;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static int getPrice() {
        return Integer.parseInt(Console.readLine());
    }
    public static String getLottoNumbers() {
        return Console.readLine();
    }
    public static int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

}
