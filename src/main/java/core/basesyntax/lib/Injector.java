package core.basesyntax.lib;

import core.basesyntax.exceptions.MissingAnnotationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;

public class Injector {
    public Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        if (clazz.getAnnotation(Dao.class) == null) {
            throw new MissingAnnotationException("Annotation Dao is missing");
        }
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instant = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.)
        }
    }
}
