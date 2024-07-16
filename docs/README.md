#Lotto 클래스
기본 Lotto클래스에 추가된 기능은 다음과 같습니다.

- public Lotto() : 기본 생성자. 다른 클래스에서 Lotto 클래스를 초기화하여 사용하기 위해 만들었습니다.
- public List<Integer> getNumbers() : Lotto 클래스의 멤버변수 numbers를 반환하는 함수.
- public int rankLotto(List<Integer> userNumbers, int bonus) : Lotto class에 저장된 로또 번호와 당첨번호 userNumbers, 보너스번호 bonus를 이용하여 복권의 등수를 계산합니다.
- public int checkLRank(int cnt, boolean bonusFlag) : rankLotto 함수에서 당첨번호와 겹치는 번호의 개수 cnt, 보너스번호의 당첨 유무 bonusFlag를 이용하여 복권의 등수를 계산합니다.

#InputInfo 클래스
사용자의 입력을 처리하는 클래스입니다. 로또구매금액, 당첨번호, 보너스 번호를 입력받고 예외를 처리합니다.

-public InputInfo() : 기본 생성자. 당첨번호를 저장할 List<Integer> userNumbers와 예외처리를 위해 만든 CheckError check를 초기화합니다.
-public setPrice() : 로또구매금액을 입력받고 처리하는 함수. 구매 금액을 입력받은 뒤 "문자 예외->음수 예외->1000원으로 나누어 떨어지지 않는 예외" 순서로 예외를 처리하고 입력한 형식이 맞다면 int price 멤버변수에 저장합니다.
-public setNumbers() : 당첨번호를 입력받고 처리하는 함수. 당첨번호를 입력받은 뒤 "입력 형식 예외->입력한 숫자 개수가 다른 예외->문자 예외->중복 예외" 순서로 예외를 처리하고 입력한 형식이 맞다면 List<Integer> userNumbers 멤버 변수에 저장합니다.
-public setBonus() : 보너스번호를 입력받고 처리하는 함수. 보너스번호를 입력받은 뒤 "문자 예외->범위 예외->당첨번호와 중복된 숫자 예외" 순서로 예외를 처리하고 입력한 형식이 맞다면 int bonus 멤버변수에 저장합니다.
-public List<Integer> changeNumbersType(String[] str) : 당첨번호를 입력받는 과정에서 String[] 타입으로 입력받은 당첨번호를 List<Integer> 타입으로 변경하기 위한 함수.
-public int getPrice(), public List<Integer> getUserNumbers(), public int getBonus() : 해당 멤버변수의 값을 반환합니다.

#BuyLotto 클래스
입력받은 로또구매금액을 바탕으로 로또를 구매하기 위한 클래스입니다.

-public BuyLotto(int price) : 기본 생성자. InputInfo 클래스를 통해 입력받은 price를 매개변수로 받습니다. 또한, 객체를 생성하면서 int count 멤버변수와 Lotto[] lottos 멤버변수의 값을 setting합니다.
-public void setCount(int price) : 로또구매개수를 계산하여 int count 멤버변수에 저장합니다.
-public void setLottos() : 로또구매개수만큼의 로또를 만들고, Lotto[] lottos에 저장합니다.
-public void printBuyLottos() : 구매한 로또의 정보를 출력합니다.
-public int getCount(), public Lotto[] getLottos() : 해당 멤버변수의 값을 반환합니다.

#CalculateBenefit 클래스
입력받은 당첨번호와 보너스번호를 바탕으로 구매한 로또의 이익을 확인하기 위한 클래스입니다.

-public CalculateBenefit(int price, int bonus, Lotto[] lottos, List<Integer> userNumber) : 기본 생성자: InputInfo 클래스를 통해 입력받은 로또구매금액, 보너스번호, 구매한 로또 리스트, 당첨번호를 매개변수로 받습니다. 또한, 객체를 생성하면서 int[] lottoRank를 초기화하고, int benefit과 double benefitRate를 setting합니다.
-public void setBenefit(Lotto[] lottos) : 구매한 로또로 번 돈을 계산하는 함수. Lotto 클래스의 rankLotto를 이용하여 등수를 알아내고, 해당 등수의 상금을 모두 합하여 benefit에 저장하면서 총 이익을 계산합니다. 이 과정에서 1~5등까지의 로또 개수를 lottoRank에 저장합니다.
-public void setBenefitRate(Lotto[] lottos) : 구매한 로또로 번 돈을 바탕으로 총 수익률을 계산하는 함수. benefit을 price로 나누어 계산한 값을 benefitRate에 저장합니다.
-public int checkMoney(int rank) : 등수별 상금을 반환하는 함수. 
-public int getBenefit(), public double getBenefitRate(), public int[] getLottoRank() : 해당 멤버변수의 값을 반환합니다.

#CheckError 클래스
사용자 입력 과정에서 발생하는 예외를 확인하기 위한 클래스 입니다.

-public CheckError() : 기본생성자.
-public boolean chk_Str(String str) : str의 값이 정수에 매칭되지 않으면 오류 메세지를 출력하고 true를 반환, 매칭되면 false를 반환합니다.
-public boolean chk_Neg(int val) : val의 값이 0 또는 음수이면 오류 메세지를 출력하고 true를 반환, 0 또는 음수가 아니면 true를 반환합니다.
-public boolean chk_Mod(int price) : price의 값이 1000으로 나눠떨어지지 않으면 오류 메세지를 출력하고 true를 반환, 1000으로 나눠떨어지면 false를 반환합니다.
-public boolean chk_Count(String[] str) : str의 길이가 6이 아니면 오류 메세지를 출력하고 true를 반환, 6이면 false를 반환합니다.
-public boolean chk_Range(int val) : val의 범위가 1~45가 아니면 오류 메세지를 출력하고 true를 반환, 1~45이면 false를 반환합니다.
-public boolean chk_Duplication(String[] val) : val의 원소에 중복되는 값이 있으면 오류 메세지를 출력하고 true를 반환, 없으면 false를 반환합니다.
-public boolean chk_Input(String[] str) : str의 원소에 문자가 있으면 오류 메세지를 출력하고 true를 반환, 없으면 false를 반환합니다.
-public boolean chk_BonusDuplication(List<Integer> numbers, int bonus) : 보너스번호가 당첨번호의 숫자와 겹치면 오류 메세지를 출력하고 true를 반환, 겹치지 않으면 나눠떨어지면 false를 반환합니다.

#LottoError 클래스
CheckError 클래스에서 처리하는 예외를 다루기 위한 ENUM 클래스입니다.

#Game 클래스
InputInfo, BuyLotto, CalculateBenefit 클래스를 이용하여 로또 게임을 처리하는 클래스

-public Game() : 기본 생성자. 위의 3가지 클래스를 순차적으로 setting하여 로또 게임을 처리합니다.
-public void printResult() : 로또 게임의 당첨 통계를 출력합니다.
