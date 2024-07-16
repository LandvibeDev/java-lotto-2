package lotto;

public enum VALUESETTING {
    None_Reward(0),
    First_Reward(2000000000),
    Second_Reward(30000000),
    Third_Reward(1500000),
    Fourth_Reward(50000),
    Fifth_Reward(5000);

    private int value;
    private VALUESETTING(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
