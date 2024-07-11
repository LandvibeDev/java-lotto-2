package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputInfo { //사용자 입력 정보
    private List<Integer> userNumbers;
    private CheckError check;
    private int price;
    private int bonus;
    public InputInfo() {
        userNumbers = new ArrayList<>();
        check = new CheckError();
    }
    public int getPrice(){
        return price;
    }
    public int getBonus(){
        return bonus;
    }
    public List<Integer> getUserNumbers(){
        return userNumbers;
    }
    public List<Integer> changeNumbersType(String[] str){
        List<String> temp = Arrays.asList(str);
        List<Integer> numbers = temp.stream().map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }
    public void setNumbers(){
        try {
            System.out.println("\n당첨 번호를 번호를 입력해주세요.");
            String[] str = Console.readLine().split(",");
            if(str.length!=6){ //입력받은 개수가 6개가 아니면
                if(check.chk_Input(str)) throw new IllegalArgumentException();
                if(check.chk_Count(str)) throw new IllegalArgumentException();
            }
            for(String s: str){ if( check.chk_Str(s)) throw new IllegalArgumentException(); }
            if(check.chk_Duplication(str)) throw new IllegalArgumentException();
            userNumbers = changeNumbersType(str);
        }catch(IllegalArgumentException e){
            setNumbers();
        }
    }
    public void setPrice(){
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String str = Console.readLine();
            if(check.chk_Str(str)) throw new IllegalArgumentException();
            int price = Integer.parseInt(str);
            if(check.chk_Neg(price)) throw new IllegalArgumentException();
            if(check.chk_Mod(price)) throw new IllegalArgumentException();
            this.price = price;
        }catch(IllegalArgumentException e){
            setPrice();
        }
    }
    public void setBonus(){
        try{
            System.out.println("\n보너스 번호를 입력해주세요.");
            String str = Console.readLine();
            if(check.chk_Str(str)) throw new IllegalArgumentException();
            int bonus = Integer.parseInt(str);
            if(check.chk_Range(bonus)) throw new IllegalArgumentException();
            if(check.chk_BonusDuplication(userNumbers, bonus)) throw new IllegalArgumentException();
            this.bonus = bonus;
        }catch(IllegalArgumentException e){
            setBonus();
        }
    }
}
