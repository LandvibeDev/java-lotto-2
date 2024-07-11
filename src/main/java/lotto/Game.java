package lotto;

import java.util.*;

public class Game {
    private InputInfo input;
    private BuyLotto buy;
    private CalculateBenefit cal;
    public Game(){
        input = new InputInfo();
        input.setPrice();
        buy = new BuyLotto(input.getPrice());
        buy.printBuyLottos();
        input.setNumbers();
        input.setBonus();
        cal = new CalculateBenefit(input.getPrice(), input.getBonus(), buy.getLottos(), input.getUserNumbers());
    }
    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        int[] lottoRanks = cal.getLottoRank();
        for(int i = 4 ; i >= 0 ; i--){
            if(i==4) System.out.println("3개 일치 (5,000원) - " +  lottoRanks[i] + "개");
            if(i==3) System.out.println("4개 일치 (50,000원) - " + lottoRanks[i] + "개");
            if(i==2) System.out.println("5개 일치 (1,500,000원) - " + lottoRanks[i] + "개");
            if(i==1) System.out.println("5개 일치 (30,000,000원) - " + lottoRanks[i] + "개");
            if(i==0) System.out.println("6개 일치 (2,000,000,000원) - " + lottoRanks[i] + "개");
        }
        String s_benefitRate = String.format("%.1f", cal.getBenefitRate());
        System.out.println("총 수익률은 " + s_benefitRate + "%입니다.");
    }
}

