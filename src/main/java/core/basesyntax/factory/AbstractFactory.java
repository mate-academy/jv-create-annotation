package core.basesyntax.factory;

import core.basesyntax.controller.BetConsoleHandler;
import core.basesyntax.controller.UserConsoleHandler;
import core.basesyntax.exception.NoSuchInjectionObjectException;
import core.basesyntax.lib.Dao;
import java.util.Map;

public class AbstractFactory {
    private static final Map<Class, Object> OBJ_FACTORIES = Map
            .of(UserConsoleHandler.class, UserDaoFactory.getInstance(),
            BetConsoleHandler.class, BetDaoFactory.getInstance());

    public static Object getNecessaryInstance(Class clazz) {
        Object obj = OBJ_FACTORIES.get(clazz);
        if (obj == null || !(obj.getClass().isAnnotationPresent(Dao.class))) {
            throw new NoSuchInjectionObjectException("The required injection object was not found");
        }
        return obj;
    }
}
