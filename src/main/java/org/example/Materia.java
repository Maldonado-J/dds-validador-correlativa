package org.example;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private List<Materia> correlativas;

    public Materia(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public Materia() {
        this.correlativas = new ArrayList<>();
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}
