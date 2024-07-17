package lotto;

import java.util.Map;
import java.util.HashMap;

public class Earn {
    int[] lotto_count;
    int lotto_value;
    int sum;
    Map<Integer,Integer> dollarMap = new HashMap<Integer,Integer>();
    Map<Integer,Integer> LottoMap = new HashMap<Integer,Integer>();
    //int[] value ={0,0,5000,50000,1500000,30000000,2000000};<-이전코드. 배열범위달라지면 예외를발생시킬 수 있는 코드
    Earn(int[] lotto_count,int lotto_value){
        this.lotto_count = lotto_count; //일치하는 갯수를 담은 배열 만약 리스트 2개가 3개 당첨번호가 같으면 lotto_count[2]=2
        this.lotto_value = lotto_value; //산 복권 개수
    }
    //범위가 달라지면 예외발생하는 것을 막기위해 dollarMap으로 묶기
    void map(){

        dollarMap.put(0,0);
        dollarMap.put(1,0);
        dollarMap.put(2,5000);
        dollarMap.put(3,50000); //4개일치
        dollarMap.put(4,1500000); //5개
        dollarMap.put(5,30000000); //5개, 보너스번호일치
        dollarMap.put(6,2000000000);
        LottoMap.put(0,lotto_count[0]);
        LottoMap.put(1,lotto_count[1]);
        LottoMap.put(2,lotto_count[2]);
        LottoMap.put(3,lotto_count[3]);
        LottoMap.put(4,lotto_count[4]);
        LottoMap.put(5,lotto_count[5]);
        LottoMap.put(6,lotto_count[6]);
    }
    void sum(){
        map();
        sum=0;
        if(dollarMap.size()==LottoMap.size()){
        for(int i=0;i<dollarMap.size();i++) {
            sum += dollarMap.get(i) * LottoMap.get(i);
        }        }
    }
    void output(){
        sum();
        int Lotto = lotto_value*1000;
        double total = (double)sum/Lotto*100;
        total = Math.round(total*100)/100.0;
        System.out.println("총 수익률은 "+total+"%입니다.");
    }
}
