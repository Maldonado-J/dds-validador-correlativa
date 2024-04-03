package org.example;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        for( Materia materia : materias) {
            if(!alumno.aproboCorrelativas(materia)) return false;
        }
        return true;
    }
}
