
package com.project.app.academico.entity;

import java.io.Serializable;
import com.project.collection.TreeBinary;

@SuppressWarnings("serial")
public class Aluno implements Comparable<Aluno>, Serializable {

    private int matAluno;
    private String nomeAluno;
    private TreeBinary<Turma> listaTurmasAluno = null;

    public Aluno(int matAluno, String nomeAluno) {
        this.matAluno = matAluno;
        this.nomeAluno = nomeAluno;
        listaTurmasAluno = new TreeBinary<Turma>();
    }

    public Aluno(int matAluno) {
        this.matAluno = matAluno;
        listaTurmasAluno = new TreeBinary<Turma>();
    }

    public int getMatAluno() {
        return matAluno;
    }

    public void setMatAluno(int matAluno) {
        this.matAluno = matAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public boolean matricular(Turma turma) {
        if (listaTurmasAluno.contains(turma)) {
            return false;
        }
        listaTurmasAluno.add(turma);
        return true;
    }

    public boolean desmatricular(Turma turma) {
        if (listaTurmasAluno.contains(turma)) {
            return (listaTurmasAluno.remove(turma) != null);
        }
        return false;
    }

    public boolean procuraTurma(Turma turma) {
        return listaTurmasAluno.contains(turma);
    }

    public boolean estaMatriculadoEmAlgumaTurma() {
        if (listaTurmasAluno.getSize() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Aluno o) {
        if (this.matAluno < o.getMatAluno()) {
            return -1;
        }
        if (this.matAluno == o.getMatAluno()) {
            return 0;
        }
        return 1;
    }

    @Override
    public int hashCode() {
        return matAluno;
    }
    
}
