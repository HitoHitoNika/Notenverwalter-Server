package de.hitohitonika.notenverwalter.server.data.daos;

import de.hitohitonika.notenverwalter.server.data.entities.Teacher;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeacherDAO implements IDAO<Teacher> {

    private final EntityManager em;

    @Autowired
    public TeacherDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Teacher findById(int id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        return em.createQuery("FROM Teacher", Teacher.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        em.persist(teacher);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        em.merge(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        em.remove(teacher);
    }
}
