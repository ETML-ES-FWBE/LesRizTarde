package ch.etmles.payroll.Config;

import ch.etmles.payroll.Entities.Student;
import ch.etmles.payroll.Entities.Grade;
import ch.etmles.payroll.Repositories.StudentRepository;
import ch.etmles.payroll.Repositories.GradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  // C'est ce qui permet à Spring de détecter et d'exécuter cette classe au démarrage
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    public DataLoader(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Vérifier si la base est vide avant d'insérer des données
        if (studentRepository.count() == 0) {
            // Création des étudiants
            Student student1 = new Student("John", "Doe");
            Student student2 = new Student("Jane", "Smith");

            studentRepository.save(student1);
            studentRepository.save(student2);

            // Ajout de notes pour les étudiants
            Grade grade1 = new Grade(4.0, "Mathematic", student1);
            Grade grade2 = new Grade(5.0, "Physic", student1);
            Grade grade3 = new Grade(3.5, "Francais", student2);

            gradeRepository.save(grade1);
            gradeRepository.save(grade2);
            gradeRepository.save(grade3);

            System.out.println("Données initiales insérées avec succès !");
        } else {
            System.out.println("La base de données contient déjà des données, aucune insertion effectuée.");
        }
    }
}
