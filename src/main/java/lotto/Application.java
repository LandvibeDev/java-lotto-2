package lotto;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    private enum Prize {
        NONE(0),
        THIRD(5000),
        FOURTH(50000),
        FIFTH(1500000),
        FIFTH_BONUS(30000000),
        FIRST(2000000000);

        private final int amount;

        Prize(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }


    private static int count = 0;

    public static class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            valid(numbers);
            this.numbers = numbers;
        }

        private void valid(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }

    public static List<Integer> MakeRandomNum() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Random random = new Random();
        for (int i = numbers.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap elements
            int temp = numbers.get(index);
            numbers.set(index, numbers.get(i));
            numbers.set(i, temp);
        }

        return numbers.subList(0, 6);
    }

    public static double check(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[7]; // Index 0 is unused, matches for 1 to 6 numbers
        int bonusMatchCount = 0;
        double totalWinnings = 0.0;

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int matchCount = 0;
            for (int num : numbers) {
                if (winningNumbers.contains(num)) {
                    matchCount++;
                }
            }
            if (matchCount == 6) {
                matchCounts[6]++;
            } else {
                matchCounts[matchCount]++;
            }
            if (matchCount == 5 && numbers.contains(bonusNumber)) {
                bonusMatchCount++;
            }
        }

        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", bonusMatchCount);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[6]);

        totalWinnings += matchCounts[3] * Prize.THIRD.getAmount() +
                matchCounts[4] * Prize.FOURTH.getAmount() +
                matchCounts[5] * Prize.FIFTH.getAmount() +
                bonusMatchCount * Prize.FIFTH_BONUS.getAmount();

        return totalWinnings;
    }



    void run() {
        int purchaseAmount = PurchaseAmount();
        int num = CalculateNumber(purchaseAmount);
        List<Lotto> lottos = MakeLotto(num);
        PrintLotto(lottos);
        List<Integer> winningNumbers = PickNumbers();
        int bonusNumber = BonusNumber();
        double totalWinnings = check(lottos, winningNumbers, bonusNumber);
        PrintProfitRate(purchaseAmount, totalWinnings);
    }

    private int PurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String purchaseStr = Console.readLine();
                int purchaseAmount = Integer.parseInt(purchaseStr);
                if (purchaseAmount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int CalculateNumber(int purchaseAmount) {
        int num = purchaseAmount / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", num);
        return num;
    }

    private List<Lotto> MakeLotto(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> randomNumbers = MakeRandomNum();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    private void PrintLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            bubbleSort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }

    private void bubbleSort(List<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }


    private List<Integer> PickNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        return readNumbers();
    }

    private int BonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return readBonusNumber();
    }

    private void PrintProfitRate(int purchaseAmount, double totalWinnings) {
        double totalPurchase = purchaseAmount;
        double profitRate = (totalWinnings / totalPurchase) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }



    public static List<Integer> readNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                String[] parts = input.split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String part : parts) {
                    int num = Integer.parseInt(part.trim());
                    if (num < 1 || num > 45) {
                        throw new IllegalArgumentException();
                    }
                    numbers.add(num);
                }
                if (numbers.size() != 6) {
                    throw new IllegalArgumentException();
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static int readBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine().trim();
                int bonusNumber = Integer.parseInt(input);
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException();
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
