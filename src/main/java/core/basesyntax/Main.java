package core.basesyntax;

import core.basesyntax.controller.Controller;
import core.basesyntax.lib.Injector;

public class Main {
    public static void main(String[] args) {
        try {
            Injector.injectDaoDependency();
            Controller.controlProcess();
        } catch (IllegalArgumentException e) {
            System.out.println("@Dao was not found ");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
