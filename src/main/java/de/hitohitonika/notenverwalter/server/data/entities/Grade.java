package de.hitohitonika.notenverwalter.server.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Grade")
@Data
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Value", nullable = false)
    private int value;

    @Column(name = "Date", nullable = false)
    private Date date;

    // Beziehung zu Schüler
    @ManyToOne
    @JoinColumn(name = "student_id") // Spaltenname für Fremdschlüssel zum Schüler
    private Student student;

    // Beziehung zu Fach
    @ManyToOne
    @JoinColumn(name = "subject_id") // Spaltenname für Fremdschlüssel zum Fach
    private Subject subject;

    // Getter und Setter hier hinzufügen
}
