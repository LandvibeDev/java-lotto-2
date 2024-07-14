package lotto;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000,false),
    SECOND_PLACE(5,30_000_000,true),
    THIRD_PLACE(5, 1_500_000,false),
    FOURTH_PLACE(4, 50_000,false),
    FIFTH_PLACE(3, 5_000,false),
    NONE(0,0,false);

    private final int matchCount;
    private final int money;
    private final boolean bonusMatch;

    Rank(int matchCount, int money,boolean bonusMatch) {
        this.matchCount = matchCount;
        this.money = money;
        this.bonusMatch = bonusMatch;
    }
    public int getMatchCount() {
        return matchCount;
    }
    public int getMoney() {
        return money;
    }
    public boolean isBonusMatch() {
        return bonusMatch;
    }
    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if(matchCount == 6){
            return FIRST_PLACE;
        }
        if(matchCount == 5 && bonusMatch){
            return SECOND_PLACE;
        }
        if(matchCount == 5){
            return THIRD_PLACE;
        }
        if(matchCount == 4){
            return FOURTH_PLACE;
        }
        if(matchCount == 3){
            return FIFTH_PLACE;
        }
        return NONE;
    }
}
