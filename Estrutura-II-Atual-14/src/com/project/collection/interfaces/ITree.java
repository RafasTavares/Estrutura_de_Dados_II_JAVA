
package com.project.collection.interfaces;

public interface ITree<E, T> {  

    /**
     * Trocar o elemento na posição X por outro.
     * @param
     *      (E element) : Setar uma referencia a um objeto contido na árvore.
     *      (E newElement) : Seta um novo objeto que irá substituir o anterior.
     * @return
     *      (NodeTree<E>) : retorna o nó original que foi trocado se não nulo.
     */ 
    E replace(E element, E newElement);    
    
    /**
     * Verifica se o pespequitivo elemento está contido na árvore.
     * @param
     *      (E element) : Setar uma referencia a um objeto contido na árvore.
     * @return
     *      (boolean) : retorna "true" se o elemento "nó" foi encontrado na arvore.
     */ 
    boolean contains(E element);
    
    /**
     * Recupera o elemento contido na árvore.
     * @param
     *      (E element) : Setar uma referencia a um objeto contido na árvore.
     * @return
     *      (E) : retorna o elemento encontrado na arvore.
     */
    E retrieve(E element);
      
    /**
     * Retorna um iterador de todos os elementos "nó" da árvore.
     * @return
     *      (IIteratorGeneric<T>) : retorna um iterador de todos os elementos "nó" da árvore.
     */
    IIterator<T> iteratorNode();
    
    /**
     * Retorna um iterador de todos os elementos da árvore.
     * @return
     *      (IIterator<E>) : retorna um iterador de todos os elementos da árvore.
     */
    IIterator<E> iteratorElement();
    
    /**
     * Recupera um elemento pai.
     * @param
     *      (E element) : Setar uma referencia a um objeto filho contido na árvore.
     * @return
     *      (E) : retorna um elemento pai do elemento filho passado por parâmetro.
     */
    E getElementParent(E element);

    /**
     * Recupera o "nó" do elemento contido na árvore.
     * @param
     *      (No element) : Setar uma referencia a um objeto contido na árvore.
     * @return
     *      (T) : retorna um "nó" do elemento passado por parâmetro.
     */
    T getNodeElement(E element);
    
    /**
     * Retorna a raiz da árvore.
     * @return
     *      (T) : retorna a RAIZ da árvore.
     */
    T getNodeRoot();
    
    /**
     * Retorna o elemento da raiz da árvore.
     * @return
     *      (E) : retorna o elemento RAIZ da árvore.
     */
    E getElementRoot();
    
    /**
     * Verifica se a árvore esta vazia.
     * @return
     *      (boolean) : retorna "true" se a arvore for vazia.
     */
    boolean isTreeEmpty();
    
    /**
     * Retorna a quantidade de elemento contidos na árvore.
     * @return
     *      (boolean) : retorna uma quantidade de elementos na árvore.
     */
    int getSize();
    
    /**
     * Apaga todos os elemento contidos na árvore.
     */
    void clear();

    /**
     * Converte todos os elemento contidos na árvore em um Array.
     * @return
     *      (Object[]) : retorna um Objeto de Arrays.
     */
    Object[] toArray();
 
}
