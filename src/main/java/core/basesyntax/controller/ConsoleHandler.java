package core.basesyntax.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleHandler {
    private Map<String, Handler> handlerMap = new HashMap<>();

    {
        handlerMap.put("user", new UserHandler());
        handlerMap.put("bet", new BetHandler());
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("=== Welcome!! ==="
                + "What data you want to input?"
                + "\nuser"
                + "\nbet"
                + "\nq (for exit)");
        while (!(input = scanner.nextLine()).equals("q")) {
            if (!handlerMap.containsKey(input)) {
                System.out.println("Incorrect operation!!!");
                continue;
            }
            handlerMap.get(input).handle();
            System.out.println("Choose operation please");
            System.out.println("user"
                    + "\nbet"
                    + "\nq (for exit)");
        }
    }
}
