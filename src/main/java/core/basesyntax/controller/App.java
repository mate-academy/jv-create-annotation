package core.basesyntax.controller;

import core.basesyntax.dao.HumanDao;
import core.basesyntax.library.Inject;
import core.basesyntax.model.Human;

public class App {

    @Inject
    private static HumanDao humanDao;

    public static void something() {
        Human human1 = new Human("Vasya", 18);
        Human human2 = new Human("Andrey", 22);
        Human human3 = new Human("Kolya", 42);
        Human human4 = new Human("Zhania", 27);

        humanDao.add(human1);
        humanDao.add(human2);
        humanDao.add(human3);
        humanDao.add(human4);
    }
}