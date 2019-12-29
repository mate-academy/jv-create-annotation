package lib;

//Вообще в оттдельной библиотеке и подключается к проэкту
//если она над каким-то полем, то внедряет объект в поле

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

}
