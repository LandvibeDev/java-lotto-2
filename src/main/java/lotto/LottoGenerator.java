package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
//로또 번호 생성하는 클래스
public class LottoGenerator {
    public List<Integer>generateLottoNumber(){
        List<Integer>numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }

}
