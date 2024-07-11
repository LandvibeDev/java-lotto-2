package lotto;

import java.util.*;

public class CalculateBenefit {
    private int benefit;
    private int price;
    private int bonus;
    private double benefitRate;
    private int[] lottoRank;
    private Lotto[] lottos;
    private List<Integer> userNumbers;
    public CalculateBenefit(int price, int bonus, Lotto[] lottos, List<Integer> userNumber){
        this.price = price;
        this.bonus = bonus;
        this.lottos = lottos;
        lottoRank = new int[] {0,0,0,0,0};
        this.userNumbers = userNumber;
        setBenefit(lottos);
        setBenefitRate(lottos);
    }
    public void setBenefit(Lotto[] lottos){
        int rank;
        for(Lotto lotto : lottos){
            rank = lotto.rankLotto(userNumbers, bonus);
            benefit += checkMoney(rank);
            if(rank!=0) lottoRank[rank-1]+=1;
        }
    }
    public void setBenefitRate(Lotto[] lottos){
        int cnt = lottos.length;
        double rate = ((double) benefit / (double) price) * 100;
        benefitRate = rate;
    }
    public int checkMoney(int rank){
        if(rank == 1) return 2000000000;

        if(rank == 2) return 30000000;

        if(rank == 3) return 1500000;

        if(rank == 4) return 50000;

        if(rank == 5) return 5000;
        return 0;
    }
    public int getBenefit(){
        return benefit;
    }
    public double getBenefitRate(){
        return benefitRate;
    }
    public int[] getLottoRank(){
        return lottoRank;
    }
}
