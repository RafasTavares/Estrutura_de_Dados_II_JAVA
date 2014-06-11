/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author 10361
 */
public interface Arvore {
    public void addRaiz();
    public void inserir(Nodo no);
    public boolean removerNo(Nodo No);
    public void buscar(Item item);
    public void imprimirArvore(Nodo no);
    public boolean temFilhoDireito(Nodo No);
    public boolean temFilhoEsquerdo(Nodo no);
    public int tamanho(); // retorna a altura da arvore
    public Nodo addRaiz(Nodo raiz);
    public Nodo criarNo(Nodo no);
    public boolean eVazio(Nodo no);
    public void posicao(Nodo no);
}
