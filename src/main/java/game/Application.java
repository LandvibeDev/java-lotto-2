package game;

import lotto.Lotto;
import lotto.LottoCalculator;
import lotto.LottoGenerator;
import java.util.List;
import java.util.ArrayList;


//게임 실행해야하는 곳
public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
        //구입금액 입력해달라고 프린트
        userService.printStartMessage();

        //구매수량 입력받기
        int lottoQuantity= userService.getLottoQuantity();


        //lottos리스트는 lotto를 객체로 가지고
        //각 lotto는 객체들은 여섯개 숫자 가지고 있는 로또번호(numbers)리스트를 가짐


        //List<>는 동적이고 객체를 저장하는 느낌..
        //int[]는 크기 고정이고 숫자를 저장


        List<Lotto>lottos = new ArrayList<>();//각 로또 번호 저장할 배열만들기
        //구매수량 만큼 로또 생성
        LottoGenerator lottoGenerator = new LottoGenerator();
        for(int i=0;i<lottoQuantity;i++){
            List<Integer> numbers = lottoGenerator.generateLottoNumber();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }



        //만들어진 로또번호 출력
        userService.printGeneratedLotto(lottos);

        //로또 당첨 번호 입력 받기
        int[] LotteryWinningNumber = userService.getLotteryWinningNumber();






        //보너스 번호 입력 받기
        int bonusNumber= userService.getBonusNumber();

        //당첨결과 계산
        LottoCalculator lottoCalculator= new LottoCalculator();
        int[] matchingResult= lottoCalculator.matchingWinningNumber(LotteryWinningNumber,bonusNumber,lottos);
        int totalPrizeMoney = lottoCalculator.calculateTotalPrizeMoney(matchingResult);
        double profitRate = lottoCalculator.calculateProfitRate(lottoQuantity,totalPrizeMoney);




        //당첨 결과 출력
        userService.printResult(matchingResult,profitRate);

    }
}
