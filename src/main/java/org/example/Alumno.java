package org.example;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class Alumno {
    private List<Materia> materiasAprobadas;

    public Alumno(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean aproboCorrelativas(Materia _materia) {
        List<Materia> correlativas = _materia.getCorrelativas();
        return correlativas.isEmpty() || CollectionUtils.containsAll(correlativas, materiasAprobadas);
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }
}
