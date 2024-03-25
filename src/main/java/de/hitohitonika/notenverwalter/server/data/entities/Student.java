package de.hitohitonika.notenverwalter.server.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email", nullable = false) // "E-Mail" zu "Email" geändert
    private String email;

    // Beziehung zu Klasse
    @ManyToOne
    @JoinColumn(name = "class_id") // Spaltenname für Fremdschlüssel zur Klasse
    private Class currentClass;

    // Beziehung zu Noten
    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    // Getter und Setter hier hinzufügen
}
