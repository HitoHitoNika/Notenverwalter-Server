package de.hitohitonika.notenverwalter.server.data.daos;

import de.hitohitonika.notenverwalter.server.data.entities.Class;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClassDAO implements IDAO<Class> {

    private final EntityManager em;

    @Autowired
    public ClassDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * @param id ID of the needed Entity
     * @return Entity with matching ID
     */
    @Override
    public Class findById(int id) {
        return em.find(Class.class, id);
    }

    /**
     * @return List with all Class entities
     */
    @Override
    public List<Class> findAll() {
        return em.createQuery("FROM Class", Class.class).getResultList();
    }

    /**
     * @param theClass the Class Entity which should be saved
     */
    @Override
    @Transactional
    public void save(Class theClass) {
        em.persist(theClass);
    }

    /**
     * @param theClass the Class Entity which should be updated - NEEDS THE SAME ID
     */
    @Override
    @Transactional
    public void update(Class theClass) {
        em.merge(theClass);
    }

    /**
     * @param theClass the Class Entity which should be deleted
     */
    @Override
    public void delete(Class theClass) {
        em.remove(theClass);
    }
}
