package lotto;

public class Exception {
    public static void priceException(){
        throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 나누어 떨어져야 합니다.");
    }
    public static void onlyNumberException(){
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
    }
    public static void LottoNumberRangeException(){
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    public static void LottoNumberDuplicateException(){
        throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
    }
    public static void LottoNumberNotSixException(){
        throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
