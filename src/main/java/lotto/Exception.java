package lotto;

public class Exception {
    void exceptionOfLength(String[] numbers){
        if(numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    void exceptionOfNumber(String[] numbers) {
        for (String n : numbers) {
            int number = Integer.parseInt(n);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    void exceptionOfBonus(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    void ExceptionOfPrice(int lottoPrice) {
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
