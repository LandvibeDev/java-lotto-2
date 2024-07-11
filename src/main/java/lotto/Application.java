package lotto;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        Input_Lotto_count count = new Input_Lotto_count();
        int lotto_count = count.Input();
        Output_Lotto_count Ocount = new Output_Lotto_count(lotto_count);
        Ocount.Random();
    }
}
