
package com.project.collection.interfaces;

import com.project.collection.NodeTree;
import java.util.List;

public interface INodeTree<E> {
        
    /**
     * Seta um "nó" pai.
     * @param
     *      (NodeTree<E> parentNode) : Seta um "Nó" pai.
     */ 
    void setParentNode(NodeTree<E> parentNode);
  
    /**
     * Retorna um "nó" pai.
     * @return
     *      (NodeTree) : retorna o "NÓ" pai do perspectivo nó.
     */ 
    NodeTree<E> getParentNode();

    /**
     * Seta um filhos na sua posição "nó perspectivo".
     * @param
     *      (List<NodeTree<E>> nodeChildren) : Seta os filhos no perspectivo "NÓ".
     */ 
    void setChildren(List<NodeTree<E>> nodeChildren);  
    
    /**
     * Retorna uma lista dos filhos do perspectivo "NÓ".
     * @return
     *      (E element) : retorna uma lista dos filhos.
     */ 
    List<NodeTree<E>> getChildren();
    
    /**
     * Seta um "nó" filho e sua posição.
     * @param
     *      (int position) : Seta a posição do "NÓ" filho.
     *      (NodeTree<E> childNode) : Seta um "NÓ" filho.
     */ 
    void setChildNode(int position, NodeTree<E> nodeChild);  
    
    /**
     * Retorna uma subarvore esquerda "nó"
     * @param
     *      (int position) : Seta a posição do "NÓ" filho.
     * @return
     *      (NodeTree) : retorna um "nó" filho do perspectivo nó.
     */ 
    NodeTree<E> getChildNode(int position);
    
    /**
     * Remove um "nó" passando a posição
     * @param
     *      (int position) : Seta a posição do "NÓ" filho.
     * @return
     *      (NodeTree) : retorna um "nó" filho do perspectivo nó.
     */ 
    NodeTree<E> removeChildNode(int position);

    /**
     * Retorna verdade se o perspectivo "NÓ" não tiver filhos.
     * @return
     *      (E element) : retorna verdade se o "NÓ" não contem filhos.
     */ 
    boolean isEmptyChildren();
    
    /**
     * Retorna a quantidade de filhos de um nó.
     * @return
     *      (E element) : retorna verdade se o "NÓ" não contem filhos.
     */ 
    int getSizeChildren();
    
    /**
     * Seta ou Substitui o objeto armazenado no "nó".
     * @param
     *      (E element) : O Objeto a setar.
     */ 
    void setElement(E element); 
    
    /**
     * Retorna o objeto associado a esse "nó".
     * @return
     *      (E element) : retorna uma objeto "nó" da arvore.
     */        
    E getElement();
    
    
    /**
     * Seta ou Substitui a dimensão de onde o "NÓ" se encontra na ARVORE.
     * @param
     *      (int dimension) : seta a dimensão.
     */ 
    void setDimension(int dimension); 
    
    /**
     * Retorna a dimensão de onde o "NÓ" se encontra na ARVORE.
     * @return
     *      (E element) : retorna a dimensão do "NÓ".
     */        
    int getDimension();
    
    /**
     * Retorna verdade se o "NÓ" é um "NÓ" interno "ou seja, contem filhos e pai".
     * @return
     *      (E element) : retorna verdade se o "NÓ" é um "NÓ" interno.
     */ 
    boolean isInternal();
 
    
    /**
     * Retorna verdade se o "NÓ" é um "NÓ" externo "ou seja, não contem filhos".
     * @return
     *      (E element) : retorna verdade se o "NÓ" é um "NÓ" externo.
     */ 
    boolean isExternal();
    
    
    /**
     * Retorna verdade se o "NÓ" é um "NÓ" raiz "ou seja, não contem um pai".
     * @return
     *      (E element) : retorna verdade se o "NÓ" é um "NÓ" raiz.
     */ 
    boolean isRoot();   
    
}































