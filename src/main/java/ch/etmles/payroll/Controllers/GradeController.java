package ch.etmles.payroll.Controllers;

import ch.etmles.payroll.Entities.Grade;
import ch.etmles.payroll.Services.GradeService;
import ch.etmles.payroll.Exceptions.GradeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    // Récupérer toutes les notes
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    //curl -X GET http://localhost:8080/grades


    // Récupérer une note via l'ID
    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id)
                .orElseThrow(() -> new GradeNotFoundException(id));
    }

    //curl -X GET http://localhost:8080/grades/1


    // Créer une nouvelle note
    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    //curl -X POST "http://localhost:8080/grades" -H "Content-Type: application/json" -d "{\"gradeValue\":2.0, \"subject\":\"Science\", \"student\":{\"id\":2}}"


    // Mettre à jour une note
    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade gradeDetails) {
        return gradeService.updateGrade(id, gradeDetails);
    }

    //curl -X PUT "http://localhost:8080/grades/1" -H "Content-Type: application/json" -d "{\"gradeValue\":3.5, \"subject\":\"Mathematic\", \"student\":{\"id\":1}}"


    // Supprimer une note
    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }

    //curl -X DELETE http://localhost:8080/grades/1
}
