package controller;

import dao.BetDao;
import dao.HumanDao;
import lib.Inject;
import model.Bet;
import model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static HumanDao humanDao;

    private static Scanner scanner = new Scanner(System.in);

    static public void handle() {
        System.out.println("Если хотите сделать ставку, введите \n" +
                "сумму и риск через пробел");
        try {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }

    static public void handleAddHuman() {
        System.out.println("Введите имя и возраст через пробел");
        try {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                humanDao.add(new Human(name, age));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        } finally {
            scanner.close();
        }
    }
}

