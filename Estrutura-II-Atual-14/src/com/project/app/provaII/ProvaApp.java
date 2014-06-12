
package com.project.app.provaII;

import com.project.collection.NodeTreeBinary;

public class ProvaApp {  
    
    public static void main(String[] args) {

        ArvoreBinariaDoProfessor<Integer> arvore = new ArvoreBinariaDoProfessor<Integer>();
        
        /*
         * Questão 1
         */
        arvore.inserir(50);
        NodeTreeBinary<Integer> noParaRemover = arvore.inserir(90);
        arvore.inserir(75);
        arvore.inserir(80);
        arvore.inserir(15);
        arvore.inserir(20);
        arvore.inserir(10);
        arvore.removerNo(noParaRemover);
        
        System.out.println("## Itens Adicionados ##");
        System.out.println(" - item 50");
        System.out.println(" - item 90");
        System.out.println(" - item 75");
        System.out.println(" - item 80");
        System.out.println(" - item 15");
        System.out.println(" - item 20");
        System.out.println(" - item 10");
        System.out.println("");  
        System.out.println("Tamanho da arvore: " + arvore.getSize()); 
        System.out.println("Altura da arvore: " + arvore.getHeightNode(arvore.getNodeRoot()));
        System.out.println("Item removido (90): ");
        System.out.println("");

        /*
         * Questão 2
         */
        System.out.print("Imprimir Arvore Binaria em pré-ordem = ");     
        arvore.imprimirArvorePreOrdem(arvore.getNodeRoot());
        
        System.out.println("");
        
        System.out.print("Imprimir Arvore Binaria em Pós-ordem = ");    
        arvore.imprimirArvorePosOrdem(arvore.getNodeRoot());
            
        System.out.println("");
        System.out.println("");
        
        /*
         * Questão 3
         */
        arvore.imprimirArvore(arvore.getNodeRoot());   
        
    }    
}
