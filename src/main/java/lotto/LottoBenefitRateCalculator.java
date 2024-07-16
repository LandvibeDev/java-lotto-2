package lotto;
import java.util.*;

public class LottoBenefitRateCalculator {
    private double benefitRate;
    private int[] lottoRank;
    private int[] lottoReward;
    public LottoBenefitRateCalculator(){
        lottoRank = new int[]{0,0,0,0,0,0};
        lottoReward = new int[]{VALUESETTING.None_Reward.getValue(), VALUESETTING.Fifth_Reward.getValue(), VALUESETTING.Second_Reward.getValue(), VALUESETTING.Third_Reward.getValue()
        , VALUESETTING.Fourth_Reward.getValue(), VALUESETTING.Fifth_Reward.getValue()};
    }
    public int calculateBenefit(int amount, Lotto[] lottos, List<Integer> winningNumbers, int bonus){
        int benefit = 0;
        int rank;
        for(Lotto lotto : lottos){
            rank = lotto.rankLotto(winningNumbers, bonus);
            System.out.println(rank);
            benefit+=lottoReward[rank];
            lottoRank[rank]++;
        }
        return benefit;
    }
    public void setBenefitRate(int price, Lotto[] lottos, List<Integer> winningNumbers, int bonus){
        int benefit = calculateBenefit(price, lottos, winningNumbers, bonus);
        benefitRate = ((double) benefit / (double) price) * 100;
    }
    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i = 4 ; i >= 0 ; i--){
            if(i==4) System.out.println("3개 일치 (5,000원) - " +  lottoRank[i] + "개");
            if(i==3) System.out.println("4개 일치 (50,000원) - " + lottoRank[i] + "개");
            if(i==2) System.out.println("5개 일치 (1,500,000원) - " + lottoRank[i] + "개");
            if(i==1) System.out.println("5개 일치 (30,000,000원) - " + lottoRank[i] + "개");
            if(i==0) System.out.println("6개 일치 (2,000,000,000원) - " + lottoRank[i] + "개");
        }
        String s_benefitRate = String.format("%.1f", benefitRate);
        System.out.println("총 수익률은 " + s_benefitRate + "%입니다.");
    }
    public int[] getLottoRank(){
        return lottoRank;
    }
    public double getBenefitRate(){
        return benefitRate;
    }
}
