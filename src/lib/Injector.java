package lib;

import controller.ConsoleHandler;
import dao.BetDaoImpl;
import dao.HumanDaoImpl;
import factory.BetDaoFactory;
import factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoClass = HumanDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();

        for (Field field : consoleHandlerFields) {
            String nameClass = field.getType().getName().replace("dao.", "");

            if (nameClass.equalsIgnoreCase("betdao")
                    && betDaoImplClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
                field.setAccessible(false);
            } else if (nameClass.equalsIgnoreCase("humandao")
                    && humanDaoClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, HumanDaoFactory.getHumanDao());
                field.setAccessible(false);
            }
        }
    }
}
