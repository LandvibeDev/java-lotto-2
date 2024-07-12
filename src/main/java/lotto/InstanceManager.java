package lotto;

public class InstanceManager {
    public ConsoleInput consoleInput() {
        return new ConsoleInput();
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine();
    }

    public WinningResult winningResult() {
        return new WinningResult();
    }

    public Application application() {
        return new Application(consoleInput(), lottoMachine(), winningResult());
    }
}