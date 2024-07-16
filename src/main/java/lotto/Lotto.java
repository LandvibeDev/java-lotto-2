package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(){
        numbers = new ArrayList<>();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    public int rankLotto(List<Integer> userNumbers, int bonus){
        int rank;
        int cnt=0;
        boolean bonusFlag = false;
        for(int userNum : userNumbers){
            for(int num : numbers){
                if(num == userNum) cnt++;
                if(num == bonus) bonusFlag = true;
            }
        } 
        rank = checkRank(cnt, bonusFlag);
        return rank;
    }
    public int checkRank(int cnt, boolean bonusFlag){
        if(cnt==6){
            return 1;
        }
        if(cnt==5&&bonusFlag){
            return 2;
        }
        if(cnt==5){
            return 3;
        }
        if(cnt==4){
            return 4;
        }
        if(cnt==3){
            return 5;
        }
        return 0;
    }

    // TODO: 추가 기능 구현
}
