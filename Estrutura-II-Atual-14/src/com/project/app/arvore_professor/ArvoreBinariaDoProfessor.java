
package com.project.app.arvore_professor;

import com.project.collection.*;

@SuppressWarnings("serial")
public class ArvoreBinariaDoProfessor<E extends Comparable<E>> extends TreeBinaryDemon<E> implements IArvore<E, NodeTreeBinary<E>> {

    @Override
    public NodeTreeBinary<E> inserir(E elemento) {
        E eleTemp = add(elemento);
        if(eleTemp != null) {
            return getNodeElement(eleTemp);
        }
        return null;
    }

    @Override
    public boolean removerNo(NodeTreeBinary<E> no) {
        return removeNode(no);
    }

    @Override
    public E buscar(E item) {        
        return retrieve(item);
    }

    @Override
    public boolean temFilhoDireito(NodeTreeBinary<E> no) {
        if(no.getChildNodeRight() != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean temFilhoEsquerdo(NodeTreeBinary<E> no) {
        if(no.getChildNodeLeft()!= null) {
            return true;
        }
        return false;
    }

    @Override
    public int altura() {          
        return getHeightNode(getNodeRoot());
    }

    @Override
    public int alturaDoNo(NodeTreeBinary<E> no) {
        return getHeightNode(no);
    }
    
    @Override
    public boolean eVazio(NodeTreeBinary<E> no) {       
        return no.isNodeEmpty();
    }

    @Override
    public void imprimirArvore(NodeTreeBinary<E> no) {    
        printConsoleTree(no);
    }
    
}
