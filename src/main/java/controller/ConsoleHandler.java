package controller;

import dao.betDao;
import dao.betDaoImpl;
import factory.betDaoFactory;
import lib.Inject;
import model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
    //синглтоп(типа). Один экземпляр класса для работы. Подходит только для работы с
    //ннапример одной моделью и одным консолХэндлером
    //возвращает всегда один инстанс
    //логика создания БэтДао теперь не в консолхэндлере и проще изменить свзязь теперь фабрика
    //
    //нужна более слабая связь что бы было проще подстроиться на дргую базу или другую
    //реализацию базы данных(сторэйдж)
    //что бы друг о друге почти ничего не знали или вообще не знали

    //определяет тип данных - ищет такую реализацию и внедряет
    @Inject
    private static final betDao betDao = betDaoFactory.getBetDao();

    public static void handle() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (Exception e) {
                System.out.println("Data invalid. Try enter \"Value[ ]risk\" again.");
            }

        }
    }
}
