
package com.project.app.provaII;

import com.project.collection.*;

@SuppressWarnings("serial")
public class ArvoreBinariaDoProfessor<E extends Comparable<E>> extends TreeBinaryDemon<E> implements IArvore<E, NodeTreeBinary<E>> {

    @Override
    public NodeTreeBinary<E> inserir(E elemento) {
        NodeTreeBinary<E> nodeOfReturn = null;
        E eleTemp = add(elemento);
        if(eleTemp != null) {
            nodeOfReturn = getNodeElement(eleTemp);
        }
        balancingTree();
        return nodeOfReturn;
    }

    @Override
    public boolean removerNo(NodeTreeBinary<E> no) {
        boolean ok = removeNode(no);
        balancingTree();
        return ok;
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
        if(no.getChildNodeLeft() != null) {
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

    /*
     * IMPRIMIR EM POS-ORDEM
    */  
    private void imprimirEmPosOrdem(NodeTreeBinary<E> node) {
        if(node != null) {        
            System.out.print("(");
            imprimirEmPosOrdem(node.getChildNodeRight());
       
            System.out.print(node.getElement().toString());
            
            imprimirEmPosOrdem(node.getChildNodeLeft());             
            System.out.print(")");
        }
    }   
    public void imprimirArvorePosOrdem(NodeTreeBinary<E> node) {   
        System.out.print(node.getElement().toString() + "(");
        
        imprimirEmPosOrdem(node.getChildNodeRight());
        imprimirEmPosOrdem(node.getChildNodeLeft());
        
        System.out.print(")");
    }
    
    /*
     * IMPRIMIR EM PRE-ORDEM
    */ 
    private void imprimirEmPreOrdem(NodeTreeBinary<E> node) {
        if(node != null) {        
            System.out.print("(");
            imprimirEmPreOrdem(node.getChildNodeLeft());
       
            System.out.print(node.getElement().toString());
            
            imprimirEmPreOrdem(node.getChildNodeRight());             
            System.out.print(")");
        }
    }   
    public void imprimirArvorePreOrdem(NodeTreeBinary<E> node) {   
        System.out.print(node.getElement().toString() + "(");
        
        imprimirEmPreOrdem(node.getChildNodeLeft());
        imprimirEmPreOrdem(node.getChildNodeRight());
        
        System.out.print(")");
    }
    
}
