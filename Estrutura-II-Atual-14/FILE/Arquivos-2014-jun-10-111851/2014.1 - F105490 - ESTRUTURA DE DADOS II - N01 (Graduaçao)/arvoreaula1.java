package esii;
/**
 *
 * @author Fabio.Rocha
 */
import java.util.*;

public class Arvore_Binaria_NRecursiva {

    private static class ARVORE {

        public int num;
        public ARVORE dir, esq;
    }

    private static class PILHA {

        public ARVORE num;
        public PILHA prox;
    }

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        ARVORE raiz = null;
        ARVORE aux;
        ARVORE aux1;
        ARVORE novo;
        ARVORE anterior;
        PILHA topo;
        PILHA aux_pilha;
        int op, achou, numero;
        do {
            System.out.println("\nMENU DE OPÇÕES\n");
            System.out.println("1 - Inserir na árvore");
            System.out.println("2 - Consultar um nó da árvore");
            System.out.println("3 - Consultar toda a árvore em ordem");
            System.out.println("4 - Consultar toda a árvore em pré-ordem");
            System.out.println("5 - Consultar toda a árvore em pós-ordem");
            System.out.println("6 - Excluir um nó da árvore");
            System.out.println("7 - Esvaziar a árvore");
            System.out.println("8 - Sair");
            System.out.println("Digite sua opção: ");
            op = entrada.nextInt();
            if (op < 1 || op > 8) {
                System.out.println("Opção inválida!!");
            }

            if (op == 1) {
                System.out.println("Digite o número a ser inserido na árvore: ");
                novo = new ARVORE();
                novo.num = entrada.nextInt();
                novo.dir = null;
                novo.esq = null;
                if (raiz == null) {
                    raiz = novo;
                } else {
                    aux = raiz;
                    achou = 0;
                    while (achou == 0) {
                        if (novo.num < aux.num) {
                            if (aux.esq == null) {
                                aux.esq = novo;
                                achou = 1;
                            } else {
                                aux = aux.esq;
                            }
                        } else if (novo.num >= aux.num) {
                            if (aux.dir == null) {
                                aux.dir = novo;
                                achou = 1;
                            } else {
                                aux = aux.dir;
                            }
                        }
                    }
                }
                System.out.println("Número inserido na árvore !!");
            }

            if (op == 2) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!!");
                } else {
                    System.out.println("Digite o elemento a ser consultado");
                    numero = entrada.nextInt();
                    achou = 0;
                    aux = raiz;
                    while (aux != null && achou == 0) {
                        if (aux.num == numero){
                            System.out.print("Número encontrado na árvore!");
                            achou = 1;
                        } else if (numero < aux.num) {
                            aux = aux.esq;
                        } else {
                            aux = aux.dir;
                        }
                    }
                    if (achou == 0)
   {
                        System.out.println("Número não encontrado na árvore!");
                    }
                }
            }
            
            if (op == 3) {
            System.out.println("Digitou 3");
                if (raiz == null) {
                    System.out.println("Árvore vazia!!");
                } else {
                    System.out.println("Listando todos os elementos da árvore em ordem");
                    aux = raiz;
                    topo = null;
                    do {
                        while (aux != null) {
                            aux_pilha = new PILHA();
                            aux_pilha.num = aux;
                            aux_pilha.prox = topo;
                            topo = aux_pilha;
                            aux = aux.esq;
                        }
                        if (topo != null) {
                            aux_pilha = topo;
                            System.out.print(aux_pilha.num.num + " ");
                            aux = topo.num.dir;
                            topo = topo.prox;
                        }
                    } while (topo != null || aux != null);
                }
            }
         
     
        } while (op != 8);
    }
}
