package lotto;

public class ExceptionOfNumber {
    // 당첨번호 6개가 1-45사이 숫자가 아닌 경우 예외처리
    void exceptionOfNumber(String[] numbers, int bonusNumber) {
        for (String n : numbers) {
            int number = Integer.parseInt(n);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
