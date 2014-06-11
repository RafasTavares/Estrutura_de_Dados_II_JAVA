
package com.project.collection.interfaces;

import java.util.Comparator;
import com.project.collection.NodeTreeBinary;

public interface ITreeBinary<E> extends ITree<E, NodeTreeBinary<E>> {
    
    /**
     * Inseri uma "nó" na arvore.
     * @param
     *      (E element) : Seta um objeto
     * @return
     *      (E) : retorna o elemento que foi inserido se não nulo.
     */ 
    E add(E element); 
    
    /**
     * Inserir um elemento em uma arvore específica e sua direção.
     * @param
     *      (E obj) : Seta um objeto ao "nó".
     *      (NoArvoreBinaria<E> father) : Seta uma "NoArvoreBinaria" que pode ser uma Raiz.
     *      (int position) : Define um direção a ser inserida na arvore.
     * @return
     *      (E) : retorna o elemento que foi inserido se não nulo.
     */ 
    E add(E obj, NodeTreeBinary<E> father, int position); 
    
    /**
     * Remove uma "nó" na arvore passando um específico elemento.
     * @param
     *      (E specificElement) : Seta um elemento contido na arvore para remover
     * @return
     *      (E specificElement) : retorna o elemento que foi removido se não nulo.
     */ 
    E remove(E specificElement);
    
    /**
     * Remove uma "nó" na arvore passando um nó específico da arvore.
     * @param
     *      (NodeTreeBinary<E> specificNode) : Seta um nó contido na arvore para remover
     * @return
     *      (boolean) : retorna o true se foi removido se não false.
     */ 
    boolean removeNode(NodeTreeBinary<E> specificNode);
       
    /**
     * Retorna um Array ordenado dos elementos da árvore.
     * @param
     *      (Comparator<E> comparador) : Seta uma implementação de um Comparator<E>.
     * @return
     *      (Object[]) : Retorna um Array ordenado dos elementos da árvore.
     */
    Object[] sort(Comparator<E> comparador);
    

    void symmetric(NodeTreeBinary<E> node);
    
    void preOrder(NodeTreeBinary<E> node);
    
    void posOrder(NodeTreeBinary<E> node);
    
    int getHeightNode(NodeTreeBinary<E> node);
    
    void balancingTree();

}
