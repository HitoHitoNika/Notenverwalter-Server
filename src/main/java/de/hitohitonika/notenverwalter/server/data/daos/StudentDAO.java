package de.hitohitonika.notenverwalter.server.data.daos;

import de.hitohitonika.notenverwalter.server.data.entities.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAO implements IDAO<Student> {

    private final EntityManager em;

    @Autowired
    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    public void delete(Student student) {
        em.remove(student);
    }
}
