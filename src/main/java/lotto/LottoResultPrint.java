package lotto;

public class LottoResultPrint {
    private final int[] prizeMoney = { 5000, 50000, 1500000, 30000000, 2000000000 };

    public void printResult(int[] prizeCnt, int totalCost) {
        int totalMoney = 0;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeCnt[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCnt[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCnt[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCnt[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCnt[4] + "개");

        for (int i = 0; i < prizeCnt.length; i++) {
            totalMoney += prizeCnt[i] * prizeMoney[i];
        }

        double benefitRate = (totalMoney / totalCost) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", benefitRate);
    }
}
