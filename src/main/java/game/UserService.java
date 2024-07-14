package game;
import lotto.Lotto;
import lotto.LottoCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLOutput;
import camp.nextstep.edu.missionutils.Console;

//사용자 입력 출력 관련된 거
public class UserService {
    public void printStartMessage(){
        System.out.println("구입금액을 입력해주세요.");
    }

    public int getLottoQuantity(){
        String input = Console.readLine();
        return Integer.parseInt(input)/1000; //인트로 변환, 1000원에 1장
    }


    public void printGeneratedLotto(List<Lotto>lottos){
        int lottoQuantity= lottos.size();
        System.out.println(lottoQuantity+"개를 구매했습니다.");
        for(int i=0;i<lottos.size();i++){
            //로또 한개로 풀기
            Lotto lotto= lottos.get(i);
            //로또한개의 번호들
            List<Integer>numbers= lotto.getNumber();

            //각 번호들 문자열로 변환하기
            String string = "[";
            for(int j=0;j<numbers.size();j++){
                string += numbers.get(j);
                if(j<numbers.size()-1 )
                    string += ", ";

            }
            string+="]";

            System.out.println(string);

        }



    }
    //당첨번호 입력 받을거임 문자열->숫자를..? 입력:1,2,3,4,5,6
    public int[] getLotteryWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[]stringNumbers = input.split(",");
        int[]numbers =new int[stringNumbers.length];
        for(int i=0;i<stringNumbers.length;i++){
            numbers[i]= Integer.parseInt(stringNumbers[i]);
        }
        return numbers; //숫자 1 2 3 4 5 6
    }

    public int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
    public void printResult(int []matchingResult,double profitRate){
        System.out.println("당첨 통계\n----");
        System.out.println("3개 일치 (5,000원) - "+matchingResult[4]+"개");
        System.out.println("4개 일치 (50,000원) -5개 일치 (1,500,000원) - "+matchingResult[3]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+matchingResult[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+matchingResult[1]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+matchingResult[0]+"개");
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }


}
