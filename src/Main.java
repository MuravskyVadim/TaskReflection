import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HumanDao;
import dao.HumanDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());

        ConsoleHandler.handleAddHuman();
        HumanDao humanDao = new HumanDaoImpl();
        System.out.println(humanDao.getAll());
    }
}
