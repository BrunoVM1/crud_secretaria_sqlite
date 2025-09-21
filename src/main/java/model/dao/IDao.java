package model.dao;

import java.util.List;

public interface IDao {

    public void save(Object obj);
    public void update(Object obj);
    public boolean delete(Object obj);
    public Object find(Object obj);
    public List<Object> findAll();
}
