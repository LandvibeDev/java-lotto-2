package lotto;

public class Application {
    public static void main(String[] args) {
        InstanceManager instanceManager = new InstanceManager();
        LottoGame lottoGame = instanceManager.lottoGame();
        lottoGame.start();
    }
}
