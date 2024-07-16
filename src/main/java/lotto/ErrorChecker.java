package lotto;

import java.util.HashSet;
import java.util.List;

public class ErrorChecker {
    public ErrorChecker(){
    }
    public boolean checkString(String str){
        if(!str.matches("-?\\d+")){
            return true;
        }
        return false;
    }
    public boolean checkNegativeNumber(int val){
        if(val<=0){
            return true;
        }
        return false;
    }
    public boolean checkDivision(int price){
        if(price%1000!=0){
            return true;
        }
        return false;
    }
    public boolean checkAmount(String[] str){
        if(str.length!=6) {
            return true;
        }
        return false;
    }
    public boolean checkRange(int val){
        if(val<1 || val>45) {
            return true;
        }
        return false;
    }
    public boolean checkDuplication(List<Integer> val){
        HashSet<Integer> uniqueVal = new HashSet<>();
        for(int v : val) {
            if (!uniqueVal.add(v)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkInputFormat(String[] str){
        for(String s : str) {
            if (!s.matches("-?\\d+")) {
                return true;
            }
        }
        return false;
    }
    public boolean checkBonusDuplication(List<Integer> numbers, int bonus){
        for(int num : numbers){
            if(num == bonus) {
                return true;
            }
        }
        return false;
    }
}
