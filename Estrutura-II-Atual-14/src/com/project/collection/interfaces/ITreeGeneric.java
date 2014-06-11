
package com.project.collection.interfaces;

import com.project.collection.NodeTree;

public interface ITreeGeneric<E> extends ITree<E, NodeTree<E>>{  

    /**
     * Inseri um elemento em um "NÓ" específicando o pai na arvore.
     * @param
     *      (E elementParent) : Referencia um nó onde vai ser inserido o filho "PAI".
     *      (E element) : Seta o elemento que vai ser inserido.
     *      (int position) : Seta a posição onde vai ser inserido o filho.
     * @return
     *      (NodeTree<E>) : retorna o nó que foi inserido se não nulo.
     */ 
    E add(E elementParent, E element);   
    
    /**
     * Remove uma "nó" na arvore passando um specificNode.
     * @param
     *      (NodeTree<E> specificNode) : Seta um NodeTree<E> specificNode
     * @return
     *      (NodeTree<E>) : retorna o nó que foi removido se não nulo.
     */ 
    E remove(E specificElement); 
 
}
