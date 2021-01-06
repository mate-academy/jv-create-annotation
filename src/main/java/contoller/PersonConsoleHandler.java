package contoller;

import dao.PersonDao;
import dao.implementation.PersonDaoImpl;
import java.util.Scanner;
import model.Person;

public class PersonConsoleHandler {
    public static final int PERSON_NAME = 0;
    public static final int PERSON_AGE = 1;
    PersonDao personDao = new PersonDaoImpl();
    Scanner scanner = new Scanner(System.in);

    public void handlePerson() {
        System.out.println("Please enter persons' name and age");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            Person newPerson = null;
            try {
                try {
                    String[] personData = input.split(" ");
                    String personName = personData[PERSON_NAME];
                    int personAge = Integer.parseInt(personData[PERSON_AGE]);
                    newPerson = new Person(personName, personAge);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please enter both name and age");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid name and age");
            }
            personDao.add(newPerson);
            System.out.println(newPerson == null ? "No data" : newPerson.toString());
        }
    }

}
