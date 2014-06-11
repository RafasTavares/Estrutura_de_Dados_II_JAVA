
package com.project.app.pergunta_e_respostas;

import com.project.app.pergunta_e_respostas.entity.PerguntaResposta;
import com.project.collection.NodeTree;
import com.project.collection.TreeGeneric;
import com.project.collection.interfaces.IIterator;

public class MedidaDeEficiencia {

    public static void main(String[] args) {

        TreeGeneric<PerguntaResposta> arvore = new TreeGeneric<PerguntaResposta>();
        
        // 1ª Pergunta A, Pai "Raiz".
        PerguntaResposta pergunta_1 = new PerguntaResposta(11, "pergunta 1");
        arvore.add(null, pergunta_1);
        
        // Respostas da Pergunta 1.
        PerguntaResposta resp1_Perg_1 = new PerguntaResposta(22, "resposta 1 : P-1");
        arvore.add(pergunta_1, resp1_Perg_1);
        
        PerguntaResposta resp2_Perg_1 = new PerguntaResposta(33, "resposta 2 : P-1");      
        arvore.add(pergunta_1, resp2_Perg_1);
        
        // Setar "uma pergunta a cada resposta cima".
        PerguntaResposta pergunta_2 = new PerguntaResposta(26, "pergunta 2 : R-1");
        arvore.add(resp1_Perg_1, pergunta_2);
        
        // Seta Respostas da Pergunta 2.
        PerguntaResposta resp3_Perg_2 = new PerguntaResposta(42, "resposta 3 : P-2");
        arvore.add(pergunta_2, resp3_Perg_2);
        
        PerguntaResposta resp4_Perg_2 = new PerguntaResposta(43, "resposta 4 : P-2");      
        arvore.add(pergunta_2, resp4_Perg_2);

        IIterator<NodeTree<PerguntaResposta>> it = arvore.iteratorNode();
        NodeTree<PerguntaResposta> objNode = it.getFirst();
        while (objNode != null) {
            PerguntaResposta perguntaResposta = objNode.getElement();
            
            if(objNode.getParentNode() != null) {
                PerguntaResposta pai = objNode.getParentNode().getElement();               
                System.out.println("NÓ: " + perguntaResposta.getTexto() + " -- PAI: " + pai.getTexto());
                System.out.println(".......................................");
                System.out.println("");
            } else {
                System.out.println("NÓ: " + perguntaResposta.getTexto() + " -- PAI: null");
                System.out.println(".......................................");
                System.out.println("");
            }            
            objNode = it.getNext();
        }      
        
    }

}
