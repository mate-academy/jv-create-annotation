package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.service.InjectingExecutor;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = (ConsoleHandler) InjectingExecutor.inject(ConsoleHandler.class);
        handler.handle();
    }
}
