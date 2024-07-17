package lotto;

public enum WinningEnum {
    three(3, 5000, "3개 일치 (5,000원) - "),
    four(4, 50000, "4개 일치 (50,000원) - "),
    five(5, 1500000, "5개 일치 (1,500,000원) - "),
    bonus(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    six(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int count;
    private final int price;
    private final String message;

    WinningEnum(int count, int price, String message) {
        this.count = count;
        this.price = price;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
