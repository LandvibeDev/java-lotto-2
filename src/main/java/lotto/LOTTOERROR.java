package lotto;

public enum LOTTOERROR {

    String_Error("[ERROR] 입력한 값에 문자가 있습니다. 숫자를 입력해주세요."),
    Negative_Error("[ERROR] 입력한 값이 0 또는 음수입니다. 로또 구매 금액은 양수여야 합니다."),
    Division_Error( "[ERROR] 로또 구매 금액은 1000원으로 나누어 떨어져야 합니다."),
    Amount_Error("[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다."),
    Range_Error("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    Duplication_Error("[ERROR] 당첨 번호 6개 중 중복되는 값이 있습니다."),
    InputFormat_Error("[ERROR] 당첨 번호가 쉼표로 구분되지 않았거나 문자를 입력했습니다."),
    BonusDuplication_Error("[ERROR] 보너스 번호는 당첨 번호에 없는 숫자를 입력해야 합니다.");

    private final String message;
    LOTTOERROR(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void printMessage(){
        System.out.println(message);
    }

}
