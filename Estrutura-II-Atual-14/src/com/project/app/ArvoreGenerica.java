
package com.project.app;

import com.project.collection.NodeTree;
import com.project.collection.TreeGeneric;
import com.project.collection.interfaces.IIterator;

public class ArvoreGenerica {
    public static void main(String[] args) {

        // CRIAR UMA ARVORE PESSOA
        System.out.println("                       AA                           ");       
        System.out.println("                                                    ");        
        System.out.println("            BB                      CC              ");
        System.out.println("                                                    ");                
        System.out.println("        DD      EE           FF     GG     HH       "); 
        System.out.println(""); 
        System.out.println(""); 
        
        
        TreeGeneric<ObjetoDeApoio> treePessoa = new TreeGeneric<ObjetoDeApoio>();
        
        // RAIZ
        ObjetoDeApoio AA = new ObjetoDeApoio(11, "AA");        
        treePessoa.add(null, AA);
        
        // NÓ DIREITO
        ObjetoDeApoio BB = new ObjetoDeApoio(22, "BB");        
        treePessoa.add(AA, BB);
        
        ObjetoDeApoio DD = new ObjetoDeApoio(33, "DD");        
        treePessoa.add(BB, DD);
        
        ObjetoDeApoio EE = new ObjetoDeApoio(44, "EE");        
        treePessoa.add(BB, EE);
        
        // NÓ ESQUERDO
        ObjetoDeApoio CC = new ObjetoDeApoio(55, "CC");        
        treePessoa.add(AA, CC);
        
        ObjetoDeApoio FF = new ObjetoDeApoio(66, "FF");        
        treePessoa.add(CC, FF);
        
        ObjetoDeApoio GG = new ObjetoDeApoio(77, "GG");        
        treePessoa.add(CC, GG);
        
        ObjetoDeApoio HH = new ObjetoDeApoio(88, "GG");        
        treePessoa.add(CC, HH);

        System.out.println("Tamanho: " + treePessoa.getSize());
        System.out.println("");
        
        IIterator<NodeTree<ObjetoDeApoio>> it = treePessoa.iteratorNode();
        NodeTree<ObjetoDeApoio> objNode = it.getFirst();
        while (objNode != null) {
            ObjetoDeApoio pessoa = objNode.getElement();
            
            if( objNode.getParentNode() != null) {
                ObjetoDeApoio pai = objNode.getParentNode().getElement();               
                System.out.println("NÓ: " + pessoa.getNome() + " -- PAI: " + pai.getNome());
                System.out.println(".......................................");
                System.out.println("");
            } else {
                System.out.println("NÓ: " + pessoa.getNome() + " -- PAI: null");
                System.out.println(".......................................");
                System.out.println("");
            }
            
            objNode = it.getNext();
        }        
    }
}
