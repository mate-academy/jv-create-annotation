package core.basesyntax.factory;

import core.basesyntax.dao.PersonDaoImplantation;

public class PersonDaoFactory {
    private static PersonDaoImplantation instance;

    public static PersonDaoImplantation getPersonDao() {
        if (instance == null) {
            instance = new PersonDaoImplantation();
        }
        return instance;
    }
}
