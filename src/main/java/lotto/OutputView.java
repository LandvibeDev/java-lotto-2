package lotto;

import java.util.*;

public class OutputView {
    public OutputView(){}
    public void printPriceInputMessage(){
        System.out.println("구매금액을 입력해주세요.");
    }
    public void printWinningNumbersInputMessage(){
        System.out.println("당첨 번호를 입력해주세요.");
    }
    public void printBonusNumberInputMessage(){
        System.out.println("보너스 번호를 입력해주세요.");
    }
    public void printBoughtLottos(LottoSeller lottoSeller){
        System.out.println(lottoSeller.getAmount()+"개를 구매했습니다.");
        Lotto[] lottos = lottoSeller.getLottos();
        List<Integer> numbers;
        for(Lotto lotto : lottos){
            System.out.print("[");
            numbers = lotto.getNumbers();
            for(int i=0;i<numbers.size()-1;i++){
                System.out.print(numbers.get(i)+", ");
            }
            System.out.print(numbers.get(numbers.size()-1)+"]");
            System.out.println();
        }
    }
    public void printResult(LottoBenefitRateCalculator benefit){
        int[] lottoRank = benefit.getLottoRank();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " +lottoRank[5]+"개");
        System.out.println("4개 일치 (50,000원) - "+lottoRank[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lottoRank[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lottoRank[2]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+lottoRank[1]+"개");
        System.out.println("총 수익률은 "+String.format("%.1f", benefit.getBenefitRate())+"%입니다.");
    }
    public void printErrorMessage(Exception e){
        System.out.println(e);
    }
}
