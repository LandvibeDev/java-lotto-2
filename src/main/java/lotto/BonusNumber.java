package lotto;

import java.util.InputMismatchException;

public class BonusNumber {
    private LottoWinningNumbers winningNumbers;
    private int bonus;
    public BonusNumber(LottoWinningNumbers winningNumbers, String bonusInput) {
        this.winningNumbers = winningNumbers;
        validate(bonusInput);
        bonus = Integer.parseInt(bonusInput);
    }
    public void validate(String bonusInput){
        ErrorChecker checker = new ErrorChecker();
        if(checker.checkString(bonusInput)) throw new IllegalArgumentException(LOTTOERROR.String_Error.getMessage());
        int bonus = Integer.parseInt(bonusInput);
        if(checker.checkRange(bonus)) throw new IllegalArgumentException(LOTTOERROR.Range_Error.getMessage());
        if(checker.checkBonusDuplication(winningNumbers.getWinningNumbers(), bonus)) throw new IllegalArgumentException(LOTTOERROR.BonusDuplication_Error.getMessage());
    }
    public int getBonus(){
        return bonus;
    }
}
