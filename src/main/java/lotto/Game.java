package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public static void start(){
        Output.firstPrint();
        int price = validateAndGetPrice();
        int p = price / 1000;
        Output.secondPrint(p);
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < p; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
            lottoList.get(i).print();
        }
        Output.printWinningNumbers();
        List<Integer> myNumbers;
        myNumbers = validateAndParseNumbers(Input.getLottoNumbers());
        Output.printBonus();
        int bonusNumber = validateAndGetBonusNumber(myNumbers);

        Grading.rankGrade(lottoList, myNumbers, bonusNumber);
    }

    private static int validateAndGetBonusNumber(List<Integer> myNumbers) {
        while(true){
            try{
                int bonusNumber = Input.getBonusNumber();
                if(bonusNumber < 1 || bonusNumber > 45) {
                    Exception.LottoNumberRangeException();
                }
                if(myNumbers.contains(bonusNumber)){
                    Exception.LottoNumberDuplicateException();
                }
                return bonusNumber;
            }catch(IllegalArgumentException e){
                Exception.onlyNumberException();
            }
        }
    }
    private static int validateAndGetPrice() {
        while (true) {
            try {
                int price = Input.getPrice();
                if (price % 1000 != 0) {
                    Exception.priceException();
                }
                return price;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch(IllegalArgumentException e){
                Exception.onlyNumberException();
            }
        }
    }
    private static List<Integer> validateAndParseNumbers(String input) {
        String[] parts = input.split(",");
        if(parts.length != 6) {
            Exception.LottoNumberNotSixException();
        }
        Set<Integer> numbers = new HashSet<>();
        for (String part : parts) {
            int number = Integer.parseInt(part.trim());
            if(number < 1 || number > 45) {
                Exception.LottoNumberRangeException();
            }
            if (!numbers.add(number)) {
                Exception.LottoNumberDuplicateException();
            }
        }
        return new ArrayList<>(numbers);
    }
}
