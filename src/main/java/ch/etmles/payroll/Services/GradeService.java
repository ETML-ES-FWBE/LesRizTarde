package ch.etmles.payroll.Services;

import ch.etmles.payroll.Entities.Grade;
import ch.etmles.payroll.Repositories.GradeRepository;
import ch.etmles.payroll.Exceptions.GradeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    // Créer une note
    public Grade createGrade(Grade grade) {
        if (grade.getGradeValue() < 1 || grade.getGradeValue() > 6) {
            throw new IllegalArgumentException("La note doit être comprise entre 1 et 6 !");
        }
        return gradeRepository.save(grade);
    }

    // Obtenir une note par ID
    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    // Lister toutes les notes
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    // Mettre à jour une note
    public Grade updateGrade(Long id, Grade gradeDetails) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new GradeNotFoundException(id));

        grade.setGradeValue(gradeDetails.getGradeValue());
        grade.setSubject(gradeDetails.getSubject());
        grade.setStudent(gradeDetails.getStudent());
        return gradeRepository.save(grade);
    }

    // Supprimer une note
    public void deleteGrade(Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new GradeNotFoundException(id);
        }
        gradeRepository.deleteById(id);
    }
}
