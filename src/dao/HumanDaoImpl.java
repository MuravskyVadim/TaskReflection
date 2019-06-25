package dao;

import db.Storage;
import lib.Dao;
import model.Human;

import java.util.List;

@Dao
public class HumanDaoImpl implements HumanDao {
    @Override
    public void add(Human human) {
        Storage.humans.add(human);
    }

    @Override
    public List<Human> getAll() {
        return Storage.humans;
    }
}
