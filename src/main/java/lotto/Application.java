package lotto;

import lotto.controller.InstanceManager;
import lotto.view.LottoGame;

public class Application {
    public static void main(String[] args) {
        InstanceManager instanceManager = new InstanceManager();
        LottoGame lottoGame = instanceManager.lottoGame();
        lottoGame.start();
    }
}
