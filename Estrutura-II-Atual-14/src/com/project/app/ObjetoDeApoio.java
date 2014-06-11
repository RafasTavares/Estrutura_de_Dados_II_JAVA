
package com.project.app;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ObjetoDeApoio implements Comparable<ObjetoDeApoio>, Serializable {
    
    private int codigo;
    private String nome;

    public ObjetoDeApoio(int codigo) {
        this.codigo = codigo;
        this.nome = "";
    }
    
    public ObjetoDeApoio(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + getCodigo() + " / Nome: " + getNome();
    }

    @Override
    public int compareTo(ObjetoDeApoio o) {
        if (getCodigo() == o.getCodigo()) {
            return 0;
        }
        return 1;
    }

}
