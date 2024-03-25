package de.hitohitonika.notenverwalter.server.data.daos;

import de.hitohitonika.notenverwalter.server.data.entities.Subject;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubjectDAO implements IDAO<Subject> {

    private final EntityManager em;

    @Autowired
    public SubjectDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Subject findById(int id) {
        return em.find(Subject.class, id);
    }

    @Override
    public List<Subject> findAll() {
        return em.createQuery("FROM Subject", Subject.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Subject subject) {
        em.persist(subject);
    }

    @Override
    @Transactional
    public void update(Subject subject) {
        em.merge(subject);
    }

    @Override
    public void delete(Subject subject) {
        em.remove(subject);
    }
}
