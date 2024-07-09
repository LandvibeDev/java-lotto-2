package lotto;

public class AppConfig {
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