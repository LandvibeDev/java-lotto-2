package lotto;

public class InsertPrice {
    //구입 금액 입력
    void insertPrice(int lottoPrice) {
        ExceptionOfPrice exceptionOfPrice = new ExceptionOfPrice();
        exceptionOfPrice.ExceptionOfPrice(lottoPrice);
        System.out.println(lottoPrice / 1000 + "개를 구매했습니다.");
    }
}