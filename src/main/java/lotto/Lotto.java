package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void print(){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        System.out.print("[");
        Collections.sort(sortedNumbers);
        for (int i = 0; i < sortedNumbers.size(); i++) {
            if(i == sortedNumbers.size() - 1){
                System.out.print(sortedNumbers.get(i));
                break;
            }
            System.out.print(sortedNumbers.get(i) + ", ");
        }
        System.out.println("]");
    }
    public int countMatches(List<Integer> myNumbers){
        int matchCount = 0;
        for(int number : numbers){
            if(myNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatch(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
}
