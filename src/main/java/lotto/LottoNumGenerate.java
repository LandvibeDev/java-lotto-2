package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumGenerate {

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottoNumList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumList.add(new Lotto(numbers));
            System.out.println(numbers);
        }
        return lottoNumList;
    }
}
