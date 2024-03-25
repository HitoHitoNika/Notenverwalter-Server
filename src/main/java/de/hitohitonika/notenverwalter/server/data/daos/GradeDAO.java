package de.hitohitonika.notenverwalter.server.data.daos;

import de.hitohitonika.notenverwalter.server.data.entities.Grade;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GradeDAO implements IDAO<Grade> {

    private final EntityManager em;

    @Autowired
    public GradeDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Grade findById(int id) {
        return em.find(Grade.class, id);
    }

    @Override
    public List<Grade> findAll() {
        return em.createQuery("FROM Grade", Grade.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Grade grade) {
        em.persist(grade);
    }

    @Override
    @Transactional
    public void update(Grade grade) {
        em.merge(grade);
    }

    @Override
    public void delete(Grade grade) {
        em.remove(grade);
    }
}
