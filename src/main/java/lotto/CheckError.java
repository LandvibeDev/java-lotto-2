package lotto;

import java.util.HashSet;
import java.util.List;

public class CheckError {
    public CheckError(){
    }
    public boolean chk_Str(String str){
        if(!str.matches("-?\\d+")){
            LottoError.Str_Error.printMessage();
            return true;
        }
        return false;
    }
    public boolean chk_Neg(int val){
        if(val<=0){
            LottoError.Neg_Error.printMessage();
            return true;
        }
        return false;
    }
    public boolean chk_Mod(int price){
        if(price%1000!=0){
            LottoError.Mod_Error.printMessage();
            return true;
        }
        return false;
    }
    public boolean chk_Count(String[] str){
        if(str.length!=6) {
            LottoError.Count_Error.printMessage();
            return true;
        }
        return false;
    }
    public boolean chk_Range(int val){
        if(val<1 || val>45) {
            LottoError.Range_Error.printMessage();
            return true;
        }
        return false;
    }
    public boolean chk_Duplication(String[] val){
        HashSet<String> uniqueVal = new HashSet<>();
        for(String v : val) {
            if (!uniqueVal.add(v)) { //HashSet에 add 실패 -> false 반환 -> 중복 존재
                LottoError.Duplication_Error.printMessage();
                return true;
            }
        }
        return false;
    }
    public boolean chk_Input(String[] str){
        for(String s : str) {
            if (!s.matches("-?\\d+")) { //입력받은 값이 숫자가 아님 => 입력 형식을 지키지 않음
                LottoError.Input_Error.printMessage();
                return true;
            }
        }
        return false;
    }
    public boolean chk_BonusDuplication(List<Integer> numbers, int bonus){
        for(int num : numbers){
            if(num == bonus) {
                LottoError.BonusDuplication_Error.printMessage();
                return true;
            }
        }
        return false;
    }
}
