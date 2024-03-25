package de.hitohitonika.notenverwalter.server.data.daos;

import java.util.List;

public interface IDAO<T> {
    T findById(int id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);
}
