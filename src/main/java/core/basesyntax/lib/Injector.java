package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CasinoDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.CasinoDaoFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Injector {
    private static void getDaoMapMethod(Map<String, Method> map, Class inspectedClass) {
        Method[] methods = inspectedClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getDeclaredAnnotation(Dao.class) != null) {
                map.put(method.getName(), method);
            }
        }
    }

    public static void injectDependency() throws IllegalAccessException, InvocationTargetException {
        Map<String, Method> methodMap = new TreeMap();

        Class<BetDaoFactory> betDaoFactoryClass = BetDaoFactory.class;
        getDaoMapMethod(methodMap, betDaoFactoryClass);

        Class<CasinoDaoFactory> casinoDaoFactoryClass = CasinoDaoFactory.class;
        getDaoMapMethod(methodMap, casinoDaoFactoryClass);

        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] fields = consoleHandlerClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(null, (BetDao) methodMap.get("getBetDao").invoke(null));
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(CasinoDao.class)) {
                field.setAccessible(true);
                field.set(null, (CasinoDao) methodMap.get("getCasinoDao").invoke(null));
            }
        }
    }
}
