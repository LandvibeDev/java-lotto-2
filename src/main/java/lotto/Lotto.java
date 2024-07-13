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
        for(int i=0;i<numbers.size();i++){
            for(int j=0;j<numbers.size();j++){
                if(numbers.get(i)==numbers.get(j)){
                    throw new IllegalArgumentException("[ERROR]로또 번호에 중복된 숫자가 있으면 안됩니다.");
                }
            }
        }

    } //당첨 번호 입력의 예외 처리

    void compare1(){

        for(int i=0;i<randoms.length;i++){
           compare2(randoms[i]); //arr에는 몇개 일치하는지 정보가 들음

        }
    }
    int compare2(List<Integer> random){
        int count=0;
            for(int j=0;j<6;j++){

                if(numbers.contains(random.get(j))){ //리스트에 특정 값이 포함되어 있는지 확인
                    count++;
                }

            }
            if(count>=3){
                int bonusNum = Integer.parseInt(vonus);
                if(count==5&&random.contains(bonusNum)){
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
        void output(){
            System.out.println("당첨 통계\n---");
            System.out.println("3개 일치 (5,000원) - "+lotto_count[2]+"개");
            System.out.println("4개 일치 (50,000원) - "+lotto_count[3]+"개");
            System.out.println("5개 일치 (1,500,000원) - "+lotto_count[4]+"개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lotto_count[5]+"개");
            System.out.println("6개 일치, 보너스 볼 일치 (2,000,000,000원) - "+lotto_count[6]+"개");
        }
        //이 코드와 Dollars 라는 enum코드를 추가하면 에러가 남. 일단 없이 구현..
       /* void output(){
            int count =2;
         for(Dollars2 dollar:Dollars2.values()){
             System.out.println(dollar.getText()+lotto_count[count]+"개");
             count++;

         }*/
        }

