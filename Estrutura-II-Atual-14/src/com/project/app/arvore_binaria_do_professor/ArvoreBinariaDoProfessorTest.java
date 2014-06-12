

package com.project.app.arvore_binaria_do_professor;

import com.project.collection.NodeTreeBinary;

public class ArvoreBinariaDoProfessorTest {  
    
    public static void main(String[] args) {

        ArvoreBinariaDoProfessor<Integer> arvore = new ArvoreBinariaDoProfessor<Integer>();
        arvore.inserir(50);
        arvore.inserir(20);
        NodeTreeBinary<Integer> noTemp = arvore.inserir(70);
        arvore.inserir(25);
        arvore.inserir(33);
        arvore.inserir(65);
        arvore.inserir(35);
        
        System.out.println("## Itens Adicionados ##");
        System.out.println(" - add 50");
        System.out.println(" - add 20");
        System.out.println(" - add 70");
        System.out.println(" - add 25");
        System.out.println(" - add 33");
        System.out.println(" - add 65");
        System.out.println(" - add 35");
        System.out.println("");
        System.out.println("## Arvore Normal ##");  
        System.out.println("Tamanho da arvore: " + arvore.getSize());       
        System.out.println("Raiz da arvore: " + arvore.getElementRoot());
        System.out.println("Pai do elemento 33 da arvore: " + arvore.getElementParent(33));
        
        // Print a arvore inteira
        arvore.imprimirArvore(arvore.getNodeRoot());
        System.out.println("Altura da arvore: " + arvore.getHeightNode(arvore.getNodeRoot()));
        
        System.out.println(" ");
        System.out.println(" ------------------------------------------------------------ ");
        System.out.println(" ");
        
        // Print apenas as sub arvores do nó
        arvore.imprimirArvore(noTemp);
        System.out.println("Altura da arvore: " + arvore.getHeightNode(noTemp));
        
        arvore.balancingTree();
        
        System.out.println(" ");
        System.out.println(" ------------------------------------------------------------ ");
        System.out.println(" ");
        
        // Print a arvore inteira
        arvore.imprimirArvore(arvore.getNodeRoot());
        System.out.println("Altura da arvore: " + arvore.getHeightNode(arvore.getNodeRoot()));
    
    }    
}
