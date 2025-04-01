package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Entities.Student;
import ch.etmles.payroll.Services.StudentService;
import ch.etmles.payroll.Exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Afficher un étudiant par son prénom
    @GetMapping("/byFirstName/{firstName}")
    public Student getStudentByFirstName(@PathVariable String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }

    //curl -X GET "http://localhost:8080/students/byFirstName/Jane" -H "Content-Type: application/json"

    //Afficher tous les étudiants
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //curl -X GET http://localhost:8080/students

    //Afficher un étudiant via l'ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    //curl -X GET http://localhost:8080/students/1

    //Ajouter un étudiant
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //curl -X POST "http://localhost:8080/students" -H "Content-Type: application/json" -d "{\"firstName\":\"Sifou\", \"lastName\":\"Miaou\"}"


    // Modifier un étudiant
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    //curl -X PUT "http://localhost:8080/students/1" -H "Content-Type: application/json" -d "{\"firstName\":\"Jane\", \"lastName\":\"Doue\"}"

    //Supprimer un étudiant
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    //curl -X DELETE http://localhost:8080/students/1
}
