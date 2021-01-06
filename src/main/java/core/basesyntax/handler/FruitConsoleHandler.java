package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import java.util.Scanner;

public class FruitConsoleHandler implements Handler {
    FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void handler() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Fruit fruit;
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] parseString = input.split(" ");
                String name = parseString[0];
                int quantity = Integer.parseInt(parseString[1]);
                fruit = new Fruit(name, quantity);
                System.out.println(fruit.toString());
            } catch (Exception e) {
                throw new RuntimeException("Wrong input, try again");
            }
            if (fruit != null) {
                fruitDao.add(fruit);
            }
        }
    }
}
