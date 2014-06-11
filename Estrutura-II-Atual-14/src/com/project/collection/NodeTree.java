
package com.project.collection;

import java.io.Serializable;

import com.project.collection.interfaces.INodeTree;

import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class NodeTree<E> implements Serializable, INodeTree<E> {
    
    /** Contém o objeto associado a esse nó */
    private E element = null;
    
    /** Referencia o "NÓ" pai children */
    private NodeTree<E> parentNode = null;
    
    /** Referencia os filhos desse "NÓ" */
    private List<NodeTree<E>> nodeChildren = new ArrayList<NodeTree<E>>();
    
    /** Referencia a dimensão de onde o "NÓ" se encontra na ARVORE */
    private int dimension = 0;
    
    /**
     * Cria um nó com filhos nulos (folha)
     * Com subarvores "filhos" nulas.
     * @param 
     *      (NodeTree<E> parentNode) : Seta uma Objeto pai
     *      (E element) : Seta uma Objeto gererico
     */
    public NodeTree(NodeTree<E> parentNode, E element) {       
        this.parentNode = parentNode;
        this.element = element;
    }   
    
    /**
     * Cria um "nó" com as respectivas subarvores.
     * @param 
     *      (NodeTree<E> parentNode) : Seta uma Objeto pai
     *      (NodeTree<E> childNode) : Seta um "filho" 
     *      (int position) : seta a posição onde vai ser inserido o "NÓ" filho
     *      (E element) : Seta uma Objeto gererico
     */
    public NodeTree(NodeTree<E> parentNode, NodeTree<E> childNode, int position, E element) {
        this(parentNode, element);
        this.nodeChildren.add(position, childNode);
    }  
    
    @Override
    public void setParentNode(NodeTree<E> parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public NodeTree<E> getParentNode() {
        return this.parentNode;
    }
    
    @Override
    public void setChildren(List<NodeTree<E>> nodeChildren) {
        this.nodeChildren.addAll(nodeChildren);
    }  
    
    @Override
    public List<NodeTree<E>> getChildren() {
        return this.nodeChildren;
    }

    @Override
    public void setChildNode(int position, NodeTree<E> nodeChild) {
        if(nodeChild.isRoot()) {
            nodeChild.setParentNode(this);
        }
        this.nodeChildren.add(position, nodeChild);
    }

    @Override
    public NodeTree<E> getChildNode(int position) {
        return this.nodeChildren.get(position);
    }
    
    @Override
    public NodeTree<E> removeChildNode(int position) {
        return this.nodeChildren.remove(position);
    }

    @Override
    public boolean isEmptyChildren() {
        return nodeChildren.isEmpty();
    }
    
    @Override
    public int getSizeChildren() {
        return nodeChildren.size();
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
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public boolean isInternal() {
        if(isRoot() == false && nodeChildren.isEmpty() == false) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExternal() {
        if(isRoot() == false && nodeChildren.isEmpty() == true) {
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
