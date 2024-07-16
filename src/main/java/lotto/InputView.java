package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputView {
    public InputView(){}
    public String inputPrice(){
        String priceInput = Console.readLine();
        return priceInput;
    }
    public String[] inputWinningNumbers(){
        String inputWinningNumbers = Console.readLine();
        return inputWinningNumbers.split(",");
    }
    public String inputBonus(){
        String inputBonus = Console.readLine();
        return inputBonus;
    }
}

