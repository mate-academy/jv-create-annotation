package core.basesyntax.dao;

public class AnimalDaoFactory {
    private static AnimalDao instance;

    public static AnimalDao getAnimalDao() {
        if (instance == null) {
            instance = new AnimalDaoImpl();
        }
        return instance;
    }
}
