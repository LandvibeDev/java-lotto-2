package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class BuyLotto { //로또 구매
    private int price;
    private int count;
    private Lotto[] lottos;
    public BuyLotto(int price){
        this.price = price;
        setCount(price);
        setLottos();
    }
    public void setCount(int price){
        count = price/1000;
    }
    public void setLottos(){
        List<Integer> numbers;
        lottos = new Lotto[count];
        for(int i=0;i<count;i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos[i] = lotto;
        }
    }
    public int getCount(){
        return count;
    }
    public Lotto[] getLottos(){
        return lottos;
    }
    public void printBuyLottos(){
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        List<Integer> numbers;
        for(int i=0;i<count;i++){
            numbers = lottos[i].getNumbers();
            System.out.print("[");
            for(int j=0; j<5;j++){
                System.out.print(numbers.get(j)+", ");
            }
            System.out.print(numbers.get(5)+"]");
            System.out.println();
        }
    }
}
