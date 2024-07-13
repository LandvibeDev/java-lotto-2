package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Collections;
//구매한 로또 개수와 랜덤 로또 번호 출력하는 클래스
public class Output_Lotto_count {
    int count;
    List<Integer>[] arr; //배열안에 리스트 저장
    Output_Lotto_count(int count){
        arr = new List[count];
        this.count = count;
    }
    void Random(){
        System.out.println(count+"개를 구매했습니다.");

        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            arr[i] = numbers; //자바에서 배열 안, 리스트 사용법: arr[0].get(1)
            System.out.println(numbers);
        }
    }

}
