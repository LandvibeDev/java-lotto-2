package lotto;

public class ExceptionOfPrice {
    // 구입 금액이 1000원 단위가 아닌 경우 예외처리
    void ExceptionOfPrice(int lottoPrice) {
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
