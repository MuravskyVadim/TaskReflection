package lib;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HumanDao;
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
            if (field.getType().equals(BetDao.class)
                    && betDaoImplClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
                field.setAccessible(false);
            } else if (field.getType().equals(HumanDao.class)
                    && humanDaoClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, HumanDaoFactory.getHumanDao());
                field.setAccessible(false);
            }
        }
    }
}
