package core.basesyntax;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet;
            User user;
            try {
                String[] inputData = command.split(" ");
                String name = inputData[0];
                int id = Integer.parseInt(inputData[1]);
                int value = Integer.parseInt(inputData[2]);
                double risk = Double.parseDouble(inputData[3]);
                user = new User(name, id);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Write correct data");
                continue;
            }
            betDao.add(bet);
            userDao.add(user);
            System.out.println(user.toString() + " " + bet.toString());
        }
    }
}
