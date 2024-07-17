package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputDangchum {
    //당첨번호를 입력하여 리스트에 저장하는 함수
    public static List<Integer> InputDangchumm(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String dangchum = Console.readLine(); //문자열 입력받기
        String[] dangchumArr = dangchum.split(","); //문자열로 들어온 숫자를 , 기준으로 쪼개서 배열에 넣기
        List<Integer> dangArr = new ArrayList<>(); //당첨번호 저장할 리스트 만들기
        for(int i=0;i<dangchumArr.length;i++){
            dangArr.add(Integer.parseInt(dangchumArr[i])); //문자열을 정수형으로 형변환하여 리스트에 정수값을 넣음
        } //(int)로 명시적형변환하는 것은 기본형끼리 이루어져야하기에 안됨.
        return dangArr;
    }
    //보너스 번호를 입력하는 함수
    public static String Bonus_num(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        return bonus;
    }
}
