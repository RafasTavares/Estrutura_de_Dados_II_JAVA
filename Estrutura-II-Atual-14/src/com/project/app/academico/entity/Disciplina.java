
package com.project.app.academico.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Disciplina implements Comparable<Disciplina>, Serializable {

    private int codDisc = 0;
    private String nomeDisc = null;

    public Disciplina(int codDisc, String nomeDisc) {
        this.codDisc = codDisc;
        this.nomeDisc = nomeDisc;
    }

    public Disciplina(int codDisc) {
        this.codDisc = codDisc;
    }

    public int getCodDisc() {
        return codDisc;
    }

    public String getNomeDisc() {
        return nomeDisc;
    }

    public void setNomeDisc(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    @Override
    public int compareTo(Disciplina o) {
        if (this.codDisc < o.codDisc) {
            return -1;
        }
        if (this.codDisc == o.codDisc) {
            return 0;
        }
        return 1;
    }
    
}
