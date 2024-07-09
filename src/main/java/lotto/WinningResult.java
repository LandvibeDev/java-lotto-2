package lotto;

import java.util.*;

public class WinningResult {
    private static final Map<Integer, Integer> PRIZES = Map.of(
            6, 2_000_000_000,
            5, 1_500_000,
            4, 50_000,
            3, 5_000
    );

    private final Map<String, Integer> result = new HashMap<>();

    public WinningResult() {
        result.put("3개", 0);
        result.put("4개", 0);
        result.put("5개", 0);
        result.put("5개+보너스", 0);
        result.put("6개", 0);
    }

    public void checkWinning(List<Lotto> purchasedLottos, Set<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            Set<Integer> intersection = new HashSet<>(lotto.getNumbers());
            intersection.retainAll(winningNumbers);
            int matchCount = intersection.size();

            if (matchCount == 6) {
                result.put("6개", result.get("6개") + 1);
            } else if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                result.put("5개+보너스", result.get("5개+보너스") + 1);
            } else if (matchCount == 5) {
                result.put("5개", result.get("5개") + 1);
            } else if (matchCount == 4) {
                result.put("4개", result.get("4개") + 1);
            } else if (matchCount == 3) {
                result.put("3개", result.get("3개") + 1);
            }
        }
    }

    public void printWinningResult() {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", result.get("3개"));
        System.out.printf("4개 일치 (50,000원) - %d개%n", result.get("4개"));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", result.get("5개"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", result.get("5개+보너스"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", result.get("6개"));
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalWinnings = result.get("6개") * PRIZES.get(6)
                + result.get("5개+보너스") * 30_000_000
                + result.get("5개") * PRIZES.get(5)
                + result.get("4개") * PRIZES.get(4)
                + result.get("3개") * PRIZES.get(3);

        return ((double) totalWinnings / purchaseAmount) * 100;
    }
}
