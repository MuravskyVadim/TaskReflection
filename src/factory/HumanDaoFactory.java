package factory;

import dao.HumanDao;
import dao.HumanDaoImpl;

public class HumanDaoFactory {
    private static HumanDao instance;

    private HumanDaoFactory() {}

    public static HumanDao getHumanDao(){
        if (instance == null){
            return instance = new HumanDaoImpl();
        }
        return instance;
    }
}
