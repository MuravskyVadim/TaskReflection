package dao;

import model.Human;

import java.util.List;

public interface HumanDao {

    void add(Human human);

    List<Human> getAll();
}
