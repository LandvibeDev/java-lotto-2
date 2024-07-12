package lotto;


import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class WinningResult {
    private final Map<RankEnum, Integer> result = new EnumMap<>(RankEnum.class);

    public WinningResult() {
        for (RankEnum rank : RankEnum.values()) {
            result.put(rank, 0);
        }
    }

    public void checkWinning(List<Lotto> purchasedLottos, Set<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            Set<Integer> intersection = new HashSet<>(lotto.getNumbers());
            intersection.retainAll(winningNumbers);
            int matchCount = intersection.size();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            RankEnum rank = RankEnum.valueOf(matchCount, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public void printWinningResult() {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", result.get(RankEnum.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", result.get(RankEnum.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", result.get(RankEnum.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", result.get(RankEnum.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", result.get(RankEnum.FIRST));
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalWinnings = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalWinnings / purchaseAmount) * 100;
    }
}
