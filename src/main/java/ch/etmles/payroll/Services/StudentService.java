package ch.etmles.payroll.Services;

import ch.etmles.payroll.Entities.Student;
import ch.etmles.payroll.Repositories.StudentRepository;
import ch.etmles.payroll.Exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    // Créer un étudiant
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Obtenir un étudiant par ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Lister tous les étudiants
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Mettre à jour un étudiant
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        return studentRepository.save(student);
    }

    // Supprimer un étudiant
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }
}
