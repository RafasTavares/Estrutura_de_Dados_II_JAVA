
package com.project.app.pergunta_e_respostas.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PerguntaResposta implements Comparable<PerguntaResposta>, Serializable {
 
    private int codigo;
    private String texto;
    
    public PerguntaResposta(int codigo) {
        this.codigo = codigo; 
    }
    
    public PerguntaResposta(int codigo, String texto) {
        this.codigo = codigo;
        this.texto = texto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    @Override
    public int compareTo(PerguntaResposta o) {
        if (this.getCodigo() < o.getCodigo()) {
            return -1;
        }
        if (this.codigo == o.getCodigo()) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return this.getTexto();
    }

}
 