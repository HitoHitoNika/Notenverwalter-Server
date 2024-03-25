package de.hitohitonika.notenverwalter.server.rest;

import de.hitohitonika.notenverwalter.server.data.Entity;
import de.hitohitonika.notenverwalter.server.data.daos.*;
import de.hitohitonika.notenverwalter.server.data.entities.Class;
import de.hitohitonika.notenverwalter.server.data.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataEndpoint {

    private final ClassDAO classDAO;
    private final TeacherDAO teacherDAO;
    private final StudentDAO studentDAO;
    private final SubjectDAO subjectDAO;
    private final GradeDAO gradeDAO;

    @Autowired
    public DataEndpoint(ClassDAO classDAO, TeacherDAO teacherDAO, StudentDAO studentDAO, SubjectDAO subjectDAO, GradeDAO gradeDAO) {
        this.classDAO = classDAO;
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
        this.subjectDAO = subjectDAO;
        this.gradeDAO = gradeDAO;
    }

    @GetMapping(value = "/{entity}/{id}", produces = "application/json")
    public Object findById(@PathVariable("entity") String entity, @PathVariable("id") int id) {
        Object object;
        switch (Entity.fromString(entity)) {
            case CLASS -> object = classDAO.findById(id);
            case GRADE -> object = gradeDAO.findById(id);
            case STUDENT -> object = studentDAO.findById(id);
            case SUBJECT -> object = subjectDAO.findById(id);
            case TEACHER -> object = teacherDAO.findById(id);
            default -> object = null;
        }
        return object;
    }

    @GetMapping(value = "/class", produces = "application/json")
    public List<Class> findAllClasses() {
        return classDAO.findAll();
    }

    @GetMapping(value = "/teachers", produces = "application/json")
    public List<Teacher> findAllTeachers() {
        return teacherDAO.findAll();
    }

    @GetMapping(value = "/student", produces = "application/json")
    public List<Student> findAllStudents() {
        return studentDAO.findAll();
    }

    @GetMapping(value = "/class", produces = "application/json")
    public List<Subject> findAllSubjects() {
        return subjectDAO.findAll();
    }

    @PostMapping(value = "/{entity}", consumes = "application/json")
    public void save(@PathVariable("entity") String entity, @RequestBody Object object) {
        switch (Entity.fromString(entity)) {
            case CLASS -> classDAO.save((Class) object);
            case GRADE -> gradeDAO.save((Grade) object);
            case STUDENT -> studentDAO.save((Student) object);
            case SUBJECT -> subjectDAO.save((Subject) object);
            case TEACHER -> teacherDAO.save((Teacher) object);
            default -> { /* handle error */ }
        }
    }

    @PutMapping(value = "/{entity}", consumes = "application/json")
    public void update(@PathVariable("entity") String entity, @RequestBody Object object) {
        switch (Entity.fromString(entity)) {
            case CLASS -> classDAO.update((Class) object);
            case GRADE -> gradeDAO.update((Grade) object);
            case STUDENT -> studentDAO.update((Student) object);
            case SUBJECT -> subjectDAO.update((Subject) object);
            case TEACHER -> teacherDAO.update((Teacher) object);
            default -> { /* handle error */ }
        }
    }

    @DeleteMapping(value = "/{entity}", consumes = "application/json")
    public void delete(@PathVariable("entity") String entity, @RequestBody Object object) {
        switch (Entity.fromString(entity)) {
            case CLASS -> classDAO.delete((Class) object);
            case GRADE -> gradeDAO.delete((Grade) object);
            case STUDENT -> studentDAO.delete((Student) object);
            case SUBJECT -> subjectDAO.delete((Subject) object);
            case TEACHER -> teacherDAO.delete((Teacher) object);
            default -> { /* handle error */ }
        }
    }
}
