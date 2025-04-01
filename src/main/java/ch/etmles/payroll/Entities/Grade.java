package ch.etmles.payroll.Entities;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Double gradeValue;

    @Column(nullable = false)
    private String subject;

    //suppression de student via un ID, normalement avec la cascade il devrait supprimer aussi dans la table grade mais ca ne fonctionne pas

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Constructeurs
    public Grade() {}

    public Grade(Double gradeValue, String subject, Student student) {
        this.gradeValue = gradeValue;
        this.subject = subject;
        this.student = student;
    }

    // Getters et Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getGradeValue() { return gradeValue; }

    public void setGradeValue(Double gradeValue) { this.gradeValue = gradeValue; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade grade)) return false;
        return Objects.equals(id, grade.id) &&
                Objects.equals(gradeValue, grade.gradeValue) &&
                Objects.equals(subject, grade.subject) &&
                Objects.equals(student, grade.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gradeValue, subject, student);
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", gradeValue=" + gradeValue + ", subject='" + subject + '\'' +
                ", student=" + (student != null ? student.getFirstName() + " " + student.getLastName() : "None") + '}';
    }
}
