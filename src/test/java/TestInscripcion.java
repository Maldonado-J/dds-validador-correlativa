import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestInscripcion {
    // Materias sin correlativas
    private final Materia algoritmos = new Materia();
    private final Materia am1 = new Materia();
    private final Materia algebra = new Materia();
    private final Materia discreta = new Materia();

    // Materias con correlativas
    private final Materia pdp = new Materia(List.of(algoritmos));
    private final Materia dds = new Materia(List.of(pdp));
    private final Materia am2 = new Materia(Arrays.asList(am1, algebra));

    @Test
    @DisplayName("Inscripcion a una materia con correlativa aprobada, aprobada")
    void unaCorrelativaAprobada() {
        final Alumno alumno = new Alumno(List.of(pdp));
        final Inscripcion inscripcion = new Inscripcion(alumno, List.of(dds));
        assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Inscripcion a una materia sin correlativa aprobada, rechazada")
    void unaCorrelativaRechazada() {
        final Alumno alumno = new Alumno(List.of(discreta));
        final Inscripcion inscripcion = new Inscripcion(alumno, List.of(dds));
        assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Inscripcion a una materia con varias correlativas aprobadas, aprobada")
    void dosCorrelativasAprobada() {
        final Alumno alumno = new Alumno(List.of(am1, algebra));
        final Inscripcion inscripcion = new Inscripcion(alumno, List.of(am2));
        assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Inscripcion a una materia con varias correlativas, no todas aprobadas, rechazada")
    void dosCorrelativasRechazada() {
        final Alumno alumno = new Alumno(List.of(pdp, am1, discreta));
        final Inscripcion inscripcion = new Inscripcion(alumno, List.of(am2));
        assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Inscripcion a varias materias. Una no aprobada. Rechazada")
    void dosMateriasRechazada() {
        final Alumno alumno = new Alumno(List.of(pdp, am1, discreta));
        final Inscripcion inscripcion = new Inscripcion(alumno, Arrays.asList(dds, am2));
        assertFalse(inscripcion.aprobada());
    }
}
