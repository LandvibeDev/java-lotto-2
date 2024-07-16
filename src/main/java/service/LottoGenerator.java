package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Integer> generateLottoNumber(){
        List<Integer>numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }

    public List<Lotto> generateLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = generateLottoNumber(); // generateLottoNumber 메서드 호출
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }


}
