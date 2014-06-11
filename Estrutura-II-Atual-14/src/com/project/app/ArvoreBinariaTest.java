
package com.project.app;

import com.project.collection.TreeBinaryDemon;

public class ArvoreBinariaTest {

    public static void main(String[] args) {
        
        TreeBinaryDemon<Integer> arvore = new TreeBinaryDemon<Integer>();
        arvore.add(50);
        arvore.add(20);
        arvore.add(70);
        arvore.add(25);
        arvore.add(33);
        arvore.add(65);
        
        System.out.println("## Itens Adicionados ##");
        System.out.println(" - add 50");
        System.out.println(" - add 20");
        System.out.println(" - add 70");
        System.out.println(" - add 25");
        System.out.println(" - add 33");
        System.out.println(" - add 65");
        System.out.println("");

        System.out.println("## Arvore Normal ##");
        System.out.println("Tamanho da arvore: " + arvore.getSize());
        System.out.println("Raiz da arvore: " + arvore.getElementRoot());
        System.out.println("Pai do elemento 33 da arvore: " + arvore.getElementParent(33));
        
        arvore.printConsoleTree(arvore.getNodeRoot());
        
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println();

        arvore.balancingTree();
        
        System.out.println("## Arvore Balanceada ##");
        System.out.println("Tamanho da arvore: " + arvore.getSize());
        System.out.println("Raiz da arvore: " + arvore.getElementRoot());
        
        arvore.printConsoleTree(arvore.getNodeRoot());
        
    }
}
