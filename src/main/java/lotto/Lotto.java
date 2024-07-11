package lotto;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> cd87056d2fc1baa0c34b7a7c51dbcacd1b89af86
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

<<<<<<< HEAD
    public Lotto(){
        numbers = new ArrayList<>();
    }

=======
>>>>>>> cd87056d2fc1baa0c34b7a7c51dbcacd1b89af86
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
<<<<<<< HEAD
    public List<Integer> getNumbers(){
        return numbers;
    }
    public int rankLotto(List<Integer> userNumbers, int bonus){
        int rank;
        int cnt=0;
        boolean bonusFlag = false;
        for(int userNum : userNumbers){
            for(int num : numbers){
                if(userNum == num) cnt++;
                if(userNum == bonus) bonusFlag = true;
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
=======
>>>>>>> cd87056d2fc1baa0c34b7a7c51dbcacd1b89af86

    // TODO: 추가 기능 구현
}
