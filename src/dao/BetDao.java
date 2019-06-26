package dao;

import model.Bet;

import java.util.List;

public interface BetDao {
    void add(Bet human);

    List<Bet> getAll();
}
