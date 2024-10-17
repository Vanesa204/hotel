
package model.dao;

import java.util.List;



public interface Dao<T> {
    public abstract void save(T t);
    public abstract T getById(long id);
    public abstract List<T> getAll();
    public abstract void update(T t);
    public abstract void delete(T t);
}


