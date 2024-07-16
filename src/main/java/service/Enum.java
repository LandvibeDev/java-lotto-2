package service;

public class Enum {
    public enum MatchingResult{
        FIRST(0),
        SECOND(1),
        THIRD(2),
        FOURTH(3),
        FIFTH(4);

        private final int index;
        MatchingResult(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public enum Prize {
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
}
