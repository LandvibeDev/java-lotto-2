package lotto;

import java.util.List;
public class Application {
    public static void main(String[] args) {
        Input_Lotto_count inputLottoCount = new Input_Lotto_count();
        int lotto_count = inputLottoCount.Input(); //산 로또 개수
        Output_Random_Lotto outputRandomLotto = new Output_Random_Lotto(lotto_count);
        outputRandomLotto.Random();
        List<Integer>[] arr = outputRandomLotto.arr; //로또 번호 리스트들을 담은 배열
        InputDangchum inputDangchum = new InputDangchum();
        List<Integer> DangList = inputDangchum.InputDangchumm(); //당첨번호 리스트
        Lotto lotto = new Lotto(DangList,arr);
        String bonus = InputDangchum.Bonus_num(); //보너스 번호 입력하기
        lotto.vonus = bonus; //로또에 보너스 번호 넘겨주기.
        lotto.listFor(); //랜덤번호와 당첨번호 비교하기.
        int[] num = lotto.lotto_count;
        Output_Result outputResult = new Output_Result();
        Output_Result.output(num);
        Earn earn = new Earn(num,lotto_count);

        earn.output();

    }

}
