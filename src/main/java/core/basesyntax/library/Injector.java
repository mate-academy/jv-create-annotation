package core.basesyntax.library;

import core.basesyntax.factory.HumanDaoFactory;
import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException, ClassNotFoundException {
        Class<?> appClass = Class.forName("core.basesyntax.controller.App");
        Class<?> humanClass = Class.forName("core.basesyntax.model.Human");

        Field[] appFields = appClass.getDeclaredFields();
        for (Field field : appFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, HumanDaoFactory.getHumanDao());
            }
        }

        Field[] humanFields = humanClass.getDeclaredFields();
        for (Field field : humanFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, "Mate Academy");
            }
        }
    }
}
