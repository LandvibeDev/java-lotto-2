package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
public class Output_Lotto_count {
    int count;
    Output_Lotto_count(int count){
        this.count = count;
    }
    void Random(){
        System.out.println(count+"개를 구매했습니다.");
        List<Integer>[] arr = new List[count];
        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
          arr[i] = numbers;
            System.out.println(numbers);
        }
    }

}
