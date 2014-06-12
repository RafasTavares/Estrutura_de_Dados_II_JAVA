/*
    A interface no arquivo "Arvore.java" obtida no magister, em arquivos  
    "2014.1 - F105490 - ESTRUTURA DE DADOS II - N01 (Graduação)" na data 
    de 10/06/2014, está tecnicamente ineficiente para ser implementada em
    uma 'ARVORE BINARIA' pelo motivo de possuir métodos ineficientes e 
    redundantes. A descrição desses problemas está em comentário '//' nos
    métodos que apresentam esses tipos de INEFICIENCIAS para uma arvore binaria.

package arvore;
public interface Arvore {
    // redundante, pelo motivo de que quando à uma instancia de uma arvore binaria
    // e o método "inserir" é chamado pela primeira vez, não a "nó" na arvore, ou seja, 
    // a primeira inserção é de fato uma raiz.
    public void addRaiz();
    
    // sujeito à falha e indefinição de estado, exemplo: se chamar o método 
    // "inserir" passando um "nó" já contido na arvore, o que acontece? 
    // E porque passar como parâmetro um "nó"? Poderia e faz, mas sentido, 
    // passar um "Elemento" e com isso ficaria mas fácil e logico a utilização
    // desse método em uma arvore binaria de tipo definido.
    public void inserir(Nodo no);

    public boolean removerNo(Nodo No);

    // método ineficaz, pelo motivo, de que quando passando um parâmetro
    // "item", para ser buscado na arvore, o que esse método faz? O que ele retorna?
    public void buscar(Item item);

    public void imprimirArvore(Nodo no);
    public boolean temFilhoDireito(Nodo No);
    public boolean temFilhoEsquerdo(Nodo no);
    public int tamanho(); // retorna a altura da arvore

    // redundante, pelo motivo de que esse método só vai ser chamado uma vez, quando
    // à uma instancia de uma arvore binaria e o método "inserir" é chamado pela 
    // primeira vez, não a "nó" na arvore, ou seja, o método "addRaiz" vai ser chamado 
    // apenas nesta hora. 
    public Nodo addRaiz(Nodo raiz);

    // redundante e ineficaz, pelo motivo de que para ser criado um "nó" em uma
    // arvore binaria tem que ser definida uma direção, esquerda ou direita, para esse
    // "nó" poder ser inserido na arvore.
    public Nodo criarNo(Nodo no);

    public boolean eVazio(Nodo no);

    // ineficaz, qual o proposito desse método?, o que faz?
    public void posicao(Nodo no);
}

    Está sendo proposto uma nova interface semelhante com a ideia da interface
    descrita acima, porem com algumas mudanças nos métodos e parâmetro, deixando
    de forma mas clara a implementação dessa interface para uma ARVORE BINARIA.
*/
package com.project.app.arvore_binaria_do_professor;

public interface IArvore<E, T> {
    
    /**
     * Inseri uma "nó" na arvore.
     * @param
     *      (E element) : Seta um objeto
     * @return
     *      (T) : retorna o nó que foi inserido se não nulo.
     */ 
    public T inserir(E elemento);
    
    /**
     * Remove um "nó" na arvore passando um nó específico da arvore.
     * @param
     *      (T specificNode) : Seta um nó contido na arvore para remover
     * @return
     *      (boolean) : retorna o true se foi removido se não false.
     */ 
    public boolean removerNo(T no);
    
    /**
     * Recupera o elemento contido na árvore.
     * @param
     *      (E element) : Setar uma referencia a um objeto contido na árvore.
     * @return
     *      (E) : retorna o elemento encontrado na arvore se não nulo.
     */
    public E buscar(E item);
    
    /**
     * Imprimi todas as subarvores do elemento específico da arvore.
     * @param
     *      (E element) : Setar uma referencia a um objeto contido na árvore.
     */
    public void imprimirArvore(T no);
   
    /**
     * Retorna true se tiver filho à direita do nó passado como parametro.
     * @param
     *      (T no) : Setar uma referencia a um nó contido na árvore.
     * @return
     *      (boolean) : retorna true se tiver filho à direita se não false.
     */
    public boolean temFilhoDireito(T no);
    
    /**
     * Retorna true se tiver filho à esquerda do nó passado como parametro.
     * @param
     *      (T no) : Setar uma referencia a um nó contido na árvore.
     * @return
     *      (boolean) : retorna true se tiver filho à esquerda se não false.
     */
    public boolean temFilhoEsquerdo(T no);
    
    /**
     * Retorna a altura da arvore.
     * @return
     *      (int) : retorna a altura da arvore.
     */
    public int altura(); // retorna a altura da arvore
    
    /**
     * Retorna a altura de onde o nó passado como parametro está na arvore.
     * @param
     *      (T no) : Setar uma referencia a um nó contido na árvore.
     * @return
     *      (int) : retorna a altura de onde o nó está na arvore.
     */
    public int alturaDoNo(T no);
    
    /**
     * Retorna true se o nó passado como parametro estiver vazio.
     * @param
     *      (T no) : Setar uma referencia a um nó contido na árvore.
     * @return
     *      (boolean) : retorna true se tiver vazio se não false.
     */
    public boolean eVazio(T no);

}


















