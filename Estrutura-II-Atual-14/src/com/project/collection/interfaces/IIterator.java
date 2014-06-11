package com.project.collection.interfaces;

import java.io.Serializable;

public interface IIterator<T> extends Serializable {
    
    /**
     * Retorna o primeiro elemento da coleção, se não 
     * existir o primeiro elemento, retorna null.
     * @return
     *      (E) : retorna elemento da coleção.
     */
    T getFirst();

    /**
     * Retorna o proximo elemento da coleção, se não 
     * existir o próximo elemento, retorna null.
     * @return
     *      (E) : retorna elemento da coleção.
     */
    T getNext();

    /**
     * Remove da coleção o último elemento retornado
     */
    void remove();
    
}
