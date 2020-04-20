package core.basesyntax.library;

import core.basesyntax.controller.App;
import core.basesyntax.dao.HumanHumanDaoImpl;
import core.basesyntax.factory.HumanDaoFactory;
import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<App> appClass = App.class;
        Class<HumanHumanDaoImpl> humanHumanDaoImplClass = HumanHumanDaoImpl.class;

        Field[] appFields = appClass.getDeclaredFields();
        for (Field field : appFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, HumanDaoFactory.getHumanDao());
            }
        }
    }
}
