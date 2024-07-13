package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        Input_Lotto_count count = new Input_Lotto_count();
        int lotto_count = count.Input();
        Output_Lotto_count Ocount = new Output_Lotto_count(lotto_count);
        Ocount.Random();
        List<Integer>[] arr = Ocount.arr; //로또 번호 리스트들을 담은 배열
        List<Integer> DangList = InputDangchum();
        Lotto lotto = new Lotto(DangList,arr);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        lotto.vonus = bonus;
        lotto.compare1();
        lotto.output();
        int[] num = lotto.lotto_count;
        Earn earn = new Earn(num,lotto_count);

        earn.output();

    }
//당첨번호를 입력하여 리스트에 저장하는 함수
    public static List<Integer> InputDangchum(){ //당첨번호를 입력하는 함수
        System.out.println("당첨 번호를 입력해 주세요.");
        String dangchum = Console.readLine();
        String[] dangchumm = dangchum.split(",");
        List<Integer> dangArr = new ArrayList<>();
        for(int i=0;i<dangchumm.length;i++){
            dangArr.add(Integer.parseInt(dangchumm[i]));
        } //(int)로 명시적형변환하는 것은 기본형끼리 이루어져야하기에 안됨.
        return dangArr;
    }
}
