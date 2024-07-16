package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinningNumbers {
    private List<Integer> winningNumbers;
    public LottoWinningNumbers(String[] winningNumbersInput) {
        validate(winningNumbersInput);
        winningNumbers = changeNumbersType(winningNumbersInput);
    }
    public void validate(String[] winningNumbersInput){
        ErrorChecker checker = new ErrorChecker();
        if(checker.checkInputFormat(winningNumbersInput)) throw new IllegalArgumentException(LOTTOERROR.InputFormat_Error.getMessage());
        if(checker.checkAmount(winningNumbersInput)) throw new IllegalArgumentException(LOTTOERROR.Amount_Error.getMessage());
        List<Integer> winningNumbers = changeNumbersType(winningNumbersInput);
        for(int number : winningNumbers) if(checker.checkRange(number)) throw new IllegalArgumentException(LOTTOERROR.Range_Error.getMessage());
        if(checker.checkDuplication(winningNumbers)) throw new IllegalArgumentException(LOTTOERROR.Duplication_Error.getMessage());
    }
    public List<Integer> changeNumbersType(String[] str){
        List<String> temp = Arrays.asList(str);
        List<Integer> numbers = temp.stream().map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }
    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
}
