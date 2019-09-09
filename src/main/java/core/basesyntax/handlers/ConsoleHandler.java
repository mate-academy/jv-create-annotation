package core.basesyntax.handlers;

import core.basesyntax.dao.AnimalDao;
import core.basesyntax.dao.BetDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Animal;
import core.basesyntax.models.Bet;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static Scanner scanner;

    @Inject
    private static BetDao betDao;

    @Inject
    private static AnimalDao animalDao;

    private static void processAnimal(String[] data) throws IllegalArgumentException {
        Animal animal = new Animal(data[0], Integer.parseInt(data[1]));
        animalDao.add(animal);
    }

    private static void processBet(String[] data) throws IllegalArgumentException {
        Bet bet = new Bet(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
        betDao.add(bet);
    }

    public static void handle(String className) {
        try {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                if (className.equals(BetDao.class.getName())) {
                    processBet(data);
                }
                if (className.equals(AnimalDao.class.getName())) {
                    processAnimal(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }

    public static void free() {
        if (scanner != null) {
            scanner.close();
        }
    }
}