package core.basesyntax.dao;

import core.basesyntax.library.Dao;

public class DaoChecker {
    public static boolean daoAnnotationExist(Class claz) throws DaoException {
        if (!claz.isAnnotationPresent(Dao.class)) {
            throw new DaoException("Incorrect annotation in " + claz.toString());
        }
        return true;
    }
}
