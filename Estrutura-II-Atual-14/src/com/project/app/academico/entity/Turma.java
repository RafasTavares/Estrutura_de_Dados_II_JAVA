
package com.project.app.academico.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Turma implements Comparable<Turma>, Serializable {

    private int codDisc;
    private int codTurma;

    public Turma(int codDisc, int codTurma) {
        this.codDisc = codDisc;
        this.codTurma = codTurma;
    }

    public int getCodDisc() {
        return codDisc;
    }

    public int getCodTurma() {
        return codTurma;
    }

    @Override
    public int compareTo(Turma o) {
        if (codDisc < o.getCodDisc()) {
            return -1;
        }
        if (codDisc == o.getCodDisc()) {
            if (codTurma == o.getCodTurma()) {
                return 0;
            }
            if (codTurma < o.getCodTurma()) {
                return -1;
            }
            return 1;
        }
        return 1;
    }

}
