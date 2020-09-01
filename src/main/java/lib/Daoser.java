package lib;

import java.lang.reflect.Constructor;

public class Daoser {

    public static void getInstance(Class clazz) throws NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
    }
}

