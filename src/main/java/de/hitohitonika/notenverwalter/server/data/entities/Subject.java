package de.hitohitonika.notenverwalter.server.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Subject")
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name")
    private String name;

    // Beziehung zu Lehrern
    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers;

    // Beziehung zu Klassen
    @ManyToMany(mappedBy = "subjects")
    private List<Class> classes;

    // Getter und Setter hier hinzufügen
}
