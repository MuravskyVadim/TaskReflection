package factory;

import dao.BetDao;
import dao.BetDaoImpl;

public class BetDaoFactory {
    private static BetDao instance;

    private BetDaoFactory() {
    }

    public static BetDao getBetDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
