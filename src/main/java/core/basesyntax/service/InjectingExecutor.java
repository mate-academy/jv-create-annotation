package core.basesyntax.service;

import java.lang.reflect.InvocationTargetException;

public class InjectingExecutor {
    private static final Injector injector = new Injector();

    public static Object inject(Class clazz) {
        try {
            return Injector.getInstance(clazz);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
