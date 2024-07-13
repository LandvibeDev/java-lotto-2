package lotto;

public class ExceptionOfLength {
    void exceptionOfLength(String[] numbers){
        if(numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
