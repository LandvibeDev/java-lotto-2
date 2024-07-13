package lotto;

public class Earn {
    int[] lotto_count;
    int lotto_value;
    int sum;
    int[] value ={0,0,5000,50000,1500000,30000000,2000000};
    Earn(int[] lotto_count,int lotto_value){
        this.lotto_count = lotto_count;
        this.lotto_value = lotto_value;
    }
    void sum(){
        sum=0;
        for(int i=0;i<lotto_count.length;i++){
            sum+=value[i]*lotto_count[i];
        }
    }
    void output(){
        sum();
        int Lotto = lotto_value*1000;
        double total = (double)sum/Lotto*100;
        System.out.println("총 수익률은 "+total+"%입니다.");
    }
}
