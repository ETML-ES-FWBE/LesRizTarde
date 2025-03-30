package ch.etmles.payroll.Exceptions;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(Long id) {
        super("La note avec l'ID " + id + " n'a pas été trouvée.");
    }
}
