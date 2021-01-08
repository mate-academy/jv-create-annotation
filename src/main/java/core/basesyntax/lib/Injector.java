package core.basesyntax.lib;

import core.basesyntax.exception.NoAnnotationsExceptions;
import core.basesyntax.factory.FactoryBet;
import core.basesyntax.factory.FactoryFruit;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    private static final String BET_DAO = "BetDao";
    private static final String FRUIT_DAO = "FruitDao";
    private static final String DOT = ".";

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationsExceptions {
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String type = field.getType().toString().substring(field.getType()
                    .toString().lastIndexOf(DOT) + 1);
            if (field.getAnnotation(Inject.class) != null && type.equals(BET_DAO)) {
                System.out.println(type);
                field.setAccessible(true);
                field.set(instance, FactoryBet.getBetDao());
            } else if (field.getAnnotation(Inject.class) != null && type.equals(FRUIT_DAO)) {
                System.out.println(type);
                field.setAccessible(true);
                field.set(instance, FactoryFruit.getFruitDao());
            } else {
                throw new NoAnnotationsExceptions("Didn't found annotations");
            }
        }
        return instance;
    }
}
