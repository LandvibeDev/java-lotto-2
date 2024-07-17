package lotto;

import java.util.List;

//당첨 번호와 로또 번호를 비교하는 클래스
public class Lotto {
    private final List<Integer> numbers; //당첨 번호
    List<Integer>[] randoms; //랜덤 로또 번호
    int[] lotto_count = new int[7];
    String vonus;
    public Lotto(List<Integer> numbers,List<Integer>[] randoms) {
        validate(numbers); //예외확인
        this.numbers = numbers;
        this.randoms = randoms;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]로또 번호의 개수가 6개를 넘어가면 안됩니다.");
        }


    } //당첨 번호 입력의 예외 처리

    void listFor(){ //랜덤으로 받은 로또번호 리스트 갯수만큼 for문 돌리는 코드. 만약 8개 당첨번호 리스트가 있으면 8개의 리스트를 쭉 돌면서 비교해보는 코드 

        for(int i=0;i<randoms.length;i++){
           compare(randoms[i]); 

        }
    }
    //lotto_count 배열에 일치하는게 5개면 [4]에 1 추가, 이런식으로 비교해나가면서 배열에 값을 추가하는 함수.
    int compare(List<Integer> random){
        int count=0;
            for(int j=0;j<6;j++){

                if(numbers.contains(random.get(j))){ //리스트에 특정 값이 포함되어 있는지 확인
                    count++; //특정 값이 있으면 count 수를 올림.
                }

            }
            if(count>=3){
                int bonusNum = Integer.parseInt(vonus);
                if(count==5&&random.contains(bonusNum)){ //보너스 + 5개 맞추면 
                    lotto_count[5]+=1;
                }
                else if(count==5){
                    lotto_count[4]+=1;
                }
                else {
                    lotto_count[count - 1] += 1; //if 첫번째 리스트에서 3개 일치 ->
                    //Lotto_count[2] = 1
                }
             }
            return count;
        }


        }

