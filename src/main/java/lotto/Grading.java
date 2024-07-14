package lotto;

import java.util.List;

public class Grading {
    public static void rankGrade(List<Lotto> purchasedLottos, List<Integer> myNumbers, int bonusNumber){
        int[]  grades = new int[Rank.values().length];
        double totalSpent = purchasedLottos.size() * 1000;
        double totalPrize = 0;

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatches(myNumbers);
            boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, isBonusMatch);

            grades[rank.ordinal()]++;
            totalPrize += rank.getMoney();
        }
        printStats(grades);
        System.out.println("총 수익률은 " + totalBenefitEfficiency(totalSpent,totalPrize) + "%입니다.");
    }
    private static void printStats(int[] grades){
        System.out.println("당첨 통계");
        System.out.println("---");
        Rank[] ranks = Rank.values();
        for(int i = grades.length - 2; i >= 0; i--){
            Rank rank = ranks[i];
            if(rank.getMatchCount() == 5 && rank.isBonusMatch()){
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + grades[rank.ordinal()] + "개");
            }
            else {
                System.out.println(rank.getMatchCount() + "개 일치 (" + format(rank.getMoney()) + ") - " + grades[rank.ordinal()] + "개");
            }
        }
    }
    private static String format(int amount){
        return String.format("%,d원", amount);
    }
    private static String totalBenefitEfficiency(double totalSpent, double totalPrize){
        double efficiency =  totalPrize / totalSpent * 100;
        return String.format("%.1f", efficiency);
    }
}
