package core.basesyntax.library;

public class DaoChecker {

    public static boolean checkDaoAnnotationExist(Class claz) throws DaoException {
        if (!claz.isAnnotationPresent(Dao.class)) {
            throw new DaoException("No Annotation 'Dao' in " + claz.toString());
        }
        return true;
    }
}
