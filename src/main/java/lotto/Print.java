package lotto;

public class Print {
    void printStatistics(int[] winningCount) {
        for (WinningEnum winning : WinningEnum.values()) {
            System.out.println(winning.getMessage() + winningCount[winning.getCount()] + "개");
        }
    }

    //수익률 출력
    void printEarningRate(int[] winningCount, int lottoPrice) {
        int totalPrice = 0;
        for (WinningEnum winning : WinningEnum.values()) {
            totalPrice += (winning.getPrice() * winningCount[winning.getCount()]);
        }
        double e = (double) totalPrice / lottoPrice;
        double earningRate = (Math.round(e*1000)/10.0);
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
