
package com.project.collection.interfaces;

import com.project.collection.NodeTreeBinary;

public interface INodeTreeBinary<E> {

    /**
     * Seta um "nó" pai.
     * @param
     *      (NodeTreeBinary<E> parentNode) : Seta um "Nó" pai.
     */ 
    void setParentNode(NodeTreeBinary<E> parentNode);
  
    /**
     * Retorna um "nó" pai.
     * @return
     *      (NodeTreeBinary) : retorna o "NÓ" pai do perspectivo nó.
     */ 
    NodeTreeBinary<E> getParentNode();
    
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
     * Seta um "nó" filho a direita.
     * @param
     *      (NodeTreeBinary<E> childNode) : Seta um "NÓ" filho.
     */ 
    void setChildNodeRight(NodeTreeBinary<E> nodeChild);  
    
    /**
     * Retorna uma subarvore direita "nó"
     * @return
     *      (NodeTreeBinary) : retorna um "nó" filho do perspectivo nó a direita.
     */ 
    NodeTreeBinary<E> getChildNodeRight();
    
    /**
     * Seta um "nó" filho a esquerda.
     * @param
     *      (NodeTreeBinary<E> childNode) : Seta um "NÓ" filho.
     */ 
    void setChildNodeLeft(NodeTreeBinary<E> nodeChild);  
    
    /**
     * Retorna uma subarvore esquerda "nó"
     * @return
     *      (NodeTreeBinary) : retorna um "nó" filho do perspectivo nó a esquerda.
     */ 
    NodeTreeBinary<E> getChildNodeLeft();
     
    /**
     * Atribui o filho do nó de acordo com o valor de direcao. Se direcao < 0
     * atribui o filho esquerdo, caso contrário, atribui o filho direito.
     * @param
     *      (int position) : Seta a direção do filho "folha"
     *      (NodeTreeBinary<E> nodeChild) : Seta um o Objeto filho
     */ 
    void setChildNode(int position, NodeTreeBinary<E> nodeChild); 
    
    /**
     * Retorna o filho do nó de acordo com o valor de direcao. Se direcao < 0
     * retorna o filho esquerdo caso contrário retorna o filho direito.
     * @param
     *      (int) : seta a direção do filho "folha".
     * @return
     *      (NodeTreeBinary) : retorna uma objeto pai "nó" da arvore
     */ 
    NodeTreeBinary<E> getChildNode(int position);  

    /**
     * Remove um "nó" passando a posição
     * @param
     *      (int position) : Seta a posição do "NÓ" filho.
     * @return
     *      (NodeTreeBinary) : retorna um "nó" filho do perspectivo nó.
     */ 
    NodeTreeBinary<E> removeChildNode(int position);

    /**
     * Retorna verdade se o perspectivo "NÓ" não tiver filhos.
     * @return
     *      (boolean) : retorna verdade se o "NÓ" não contem filhos.
     */ 
    boolean isNodeEmpty();
    
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































