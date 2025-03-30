package ch.etmles.payroll.Exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("L'étudiant avec l'ID " + id + " n'a pas été trouvé.");
    }
}
