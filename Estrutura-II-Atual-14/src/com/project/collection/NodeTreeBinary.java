
package com.project.collection;

import java.io.Serializable;

import com.project.collection.interfaces.INodeTreeBinary;

@SuppressWarnings("serial")
public class NodeTreeBinary<E> implements Serializable, INodeTreeBinary<E> {
    
    /** Contém o objeto associado a esse nó */
    private E element = null;
    
    /** Referencia o "NÓ" pai children */
    private NodeTreeBinary<E> parentNode = null;
    
    /** Referencia os filhos desse "NÓ" a direita e esquerda*/
    private NodeTreeBinary<E> nodeChildRight = null;
    private NodeTreeBinary<E> nodeChildLeft = null;
    
    /** Referencia a altura do "NÓ" na arvore */
    public int height = 0;
     
    /**
     * Cria um nó com filhos nulos (folha)
     * Com subarvores "filhos" nulas.
     * @param 
     *      (NodeTree<E> parentNode) : Seta uma Objeto pai
     *      (E element) : Seta uma Objeto gererico
     */
    public NodeTreeBinary(NodeTreeBinary<E> parentNode, E element) {       
        this.parentNode = parentNode;
        this.element = element;
    }   
       
    /**
     * Cria um "nó" com as respectivas subarvores esquerda e direita.
     * @param 
     *      (NoArvoreBinaria<E> pai) : Seta uma Objeto pai
     *      (NoArvoreBinaria<E> esq) : Seta uma "folha" esquerdo 
     *      (NoArvoreBinaria<E> dir) : Seta uma "folha" direito
     *      (E obj) : Seta uma Objeto gererico
     */
    public NodeTreeBinary(NodeTreeBinary<E> parentNode, NodeTreeBinary<E> nodeChildRight, NodeTreeBinary<E> nodeChildLeft, E element) {
        this(parentNode, element);
        this.nodeChildRight = nodeChildRight;
        this.nodeChildLeft = nodeChildLeft;
    }  
        
    @Override
    public void setParentNode(NodeTreeBinary<E> parentNode) {
        this.parentNode = parentNode;
    }
    
    @Override
    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public E getElement() {
        return element;
    }

    @Override
    public NodeTreeBinary<E> getParentNode() {
        return this.parentNode;
    }

    @Override
    public void setChildNodeRight(NodeTreeBinary<E> nodeChild) {
        this.nodeChildRight = nodeChild;
    } 
    
    @Override
    public NodeTreeBinary<E> getChildNodeRight() {
        return nodeChildRight;
    }
    
    @Override
    public void setChildNodeLeft(NodeTreeBinary<E> nodeChild) {
        this.nodeChildLeft = nodeChild;
    } 
    
    @Override
    public NodeTreeBinary<E> getChildNodeLeft() {
        return nodeChildLeft;
    }

    @Override
    public void setChildNode(int position, NodeTreeBinary<E> nodeChild) {
        if (position < 0) {
            nodeChildLeft = nodeChild;
        } else {
            nodeChildRight = nodeChild;
        }
    }

    @Override
    public NodeTreeBinary<E> getChildNode(int position) {
        if (position < 0) {
            return nodeChildLeft;
        } else {
            return nodeChildRight;
        }
    }
    
    @Override
    public NodeTreeBinary<E> removeChildNode(int position) {
        NodeTreeBinary<E> nodeTemp = null;
        if (position < 0) {
            nodeTemp = nodeChildLeft;
            nodeChildLeft = null;
        } else {
            nodeTemp = nodeChildRight;
            nodeChildRight = null;
        }
        return nodeTemp;
    }

    @Override
    public boolean isNodeEmpty() {
        if(nodeChildRight == null && nodeChildLeft == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInternal() {
        if(isRoot() == false && isNodeEmpty() == false) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExternal() {
        if(isRoot() == false && isNodeEmpty() == true) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isRoot() {       
        if(parentNode == null) {
            return true;
        }
        return false;
    }
    
}
