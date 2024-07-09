package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final Map<Integer, Integer> PRIZES = Map.of(
            6, 2_000_000_000,
            5, 1_500_000,
            4, 50_000,
            3, 5_000
    );

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            int purchaseAmount = getPurchaseAmount();
            int numberOfLottos = purchaseAmount / LOTTO_PRICE;

            List<Lotto> purchasedLottos = generateLottos(numberOfLottos);
            printPurchasedLottos(purchasedLottos);

            Set<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber(winningNumbers);

            Map<String, Integer> winningResult = checkWinning(purchasedLottos, winningNumbers, bonusNumber);
            printWinningResult(winningResult);

            double profitRate = calculateProfitRate(winningResult, purchaseAmount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 숫자여야 합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
        return purchaseAmount;
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBERS_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Set<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] split = input.split(",");
        if (split.length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }

        Set<Integer> winningNumbers = new HashSet<>();
        for (String number : split) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
            }
            if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(num);
        }
        if (winningNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        return winningNumbers;
    }

    private static int getBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
    }

    private static Map<String, Integer> checkWinning(List<Lotto> purchasedLottos, Set<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> result = new HashMap<>();
        result.put("3개", 0);
        result.put("4개", 0);
        result.put("5개", 0);
        result.put("5개+보너스", 0);
        result.put("6개", 0);

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
        return result;
    }

    private static void printWinningResult(Map<String, Integer> winningResult) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", winningResult.get("3개"));
        System.out.printf("4개 일치 (50,000원) - %d개%n", winningResult.get("4개"));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", winningResult.get("5개"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", winningResult.get("5개+보너스"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", winningResult.get("6개"));
    }

    private static double calculateProfitRate(Map<String, Integer> winningResult, int purchaseAmount) {
        int totalWinnings = winningResult.get("6개") * PRIZES.get(6)
                + winningResult.get("5개+보너스") * 30_000_000
                + winningResult.get("5개") * PRIZES.get(5)
                + winningResult.get("4개") * PRIZES.get(4)
                + winningResult.get("3개") * PRIZES.get(3);

        return ((double) totalWinnings / purchaseAmount) * 100;
    }

}
