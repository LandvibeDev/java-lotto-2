package lotto;
import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoSeller {
    private int price;
    private int amount;
    private Lotto[] lottos;
    public LottoSeller(){}
    public LottoSeller(String priceInput){
        validate(priceInput);
        price = Integer.parseInt(priceInput);
        amount = price / 1000;
        sellLottos();
    }
    public void validate(String priceInput){
        ErrorChecker checker = new ErrorChecker();
        if(checker.checkString(priceInput)) throw new IllegalArgumentException(LOTTOERROR.String_Error.getMessage());
        int price = Integer.parseInt(priceInput);
        if(checker.checkNegativeNumber(price)) throw new IllegalArgumentException(LOTTOERROR.Negative_Error.getMessage());
        if(checker.checkDivision(price)) throw new IllegalArgumentException(LOTTOERROR.Division_Error.getMessage());
    }
    public void sellLottos(){
        lottos = new Lotto[amount];
        for(int i=0;i<amount;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(sortLotto(numbers));
            lottos[i] = lotto;
        }
    }
    public List<Integer> sortLotto(List<Integer> lotto){
        List<Integer> sortedLotto = lotto.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        return sortedLotto;
    }
    public int getPrice(){
        return price;
    }
    public int getAmount(){
        return amount;
    }
    public Lotto[] getLottos(){
        return lottos;
    }
}
