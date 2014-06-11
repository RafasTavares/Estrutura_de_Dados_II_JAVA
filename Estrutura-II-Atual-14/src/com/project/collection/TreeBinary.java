
package com.project.collection;


import java.io.Serializable;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.project.collection.interfaces.ITreeBinary;
import com.project.collection.interfaces.IIterator;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class TreeBinary<E extends Comparable<E>> implements Serializable, ITreeBinary<E>{

    protected NodeTreeBinary<E> ROOT;
    protected int countNode;
    
    public TreeBinary() {
        this.ROOT = null;
        this.countNode = 0;
    }
    
    @Override
    public E add(E element) {
        int position = 0;
        NodeTreeBinary<E> p = ROOT;
        NodeTreeBinary<E> father = null;
        if (ROOT != null) {
            while (p != null) {
                if (element.compareTo(p.getElement()) == 0) {
                    return p.getElement();
                }
                // Se "compareTo" for menor que "0" caminhe para 
                // lado "esquerdo" se não para o lado "direito"
                if (element.compareTo(p.getElement()) < 0) {
                    if (p.getChildNodeLeft() == null) {
                        father = p;
                        position = -1;
                        break;
                    }
                    p = p.getChildNodeLeft();
                } else {
                    if (p.getChildNodeRight() == null) {
                        father = p;
                        position = 1;
                        break;
                    }
                    p = p.getChildNodeRight();
                }
            }
        }       
        // Se a "raiz" for nula, cria a raiz principal da arvore.
        return add(element, father, position);
    }

    @Override
    public E add(E obj, NodeTreeBinary<E> father, int position) {
        NodeTreeBinary<E> newNode = new NodeTreeBinary<E>(father, obj);
        if (father == null) {
            ROOT = newNode;
            countNode++;
            return obj;
        } 
        else if (father.getChildNode(position) != null) {
            return null;
        }

        father.setChildNode(position, newNode);
        countNode++;
        return obj;
    }

    @Override
    public E remove(E specificElement) {     
        NodeTreeBinary<E> specificNode = getNodeElement(specificElement);
        if(specificNode != null) {
            E elementTemp = specificNode.getElement();
            // Se a remoção "removeNode" for verdadeira 
            // retorna o "elementTemp" se não nulo
            return (removeNode(specificNode) == true ? elementTemp : null);
        }
        return null;
    }

    @Override
    public boolean removeNode(NodeTreeBinary<E> specificNode) {
        NodeTreeBinary<E> childNode;
        // Verifica se o "nó" tem os dois filhos
        if ((specificNode.getChildNodeRight() != null) && (specificNode.getChildNodeLeft() != null)) {
            NodeTreeBinary<E> pTemp = null;
            
	    // Procura na subarvore esquerda o
            // "nó" que se encontra mais a direita
            pTemp = specificNode.getChildNodeLeft();
            while (pTemp.getChildNodeRight() != null) {
                pTemp = pTemp.getChildNodeRight();
            }
            
	    // Copia o objeto do no que se encontra mais
            // a direita no no que desejamos remover
            specificNode.setElement(pTemp.getElement());
	    
            // Faz com que o no a ser removido seja o no
            // que se encontra mais a direita da subarvore
            // esquerda
            specificNode = pTemp;
        }
        // Verifica se esta removendo a raiz
        if (specificNode == ROOT) {
            if (ROOT.getChildNodeLeft() != null) {
                ROOT = ROOT.getChildNodeLeft();
            } else {
                ROOT = ROOT.getChildNodeRight();
            }
            if (ROOT != null) {
                ROOT.setParentNode(null);
            }
            countNode--;
            
            return true;
        } else {
            int position = 1;
            NodeTreeBinary<E> father = specificNode.getParentNode();
            if (specificNode == father.getChildNodeLeft()) {
                position = -1;
            }         
            childNode = father.getChildNode(position);
            if (childNode == null) {
                countNode--;
                return true;
            }
            if (childNode.getChildNodeLeft() != null) {
                father.setChildNode(position, childNode.getChildNodeLeft());
                childNode.getChildNodeLeft().setParentNode(father);
            } else {
                father.setChildNode(position, childNode.getChildNodeRight());
                if (childNode.getChildNodeRight() != null) {
                    childNode.getChildNodeRight().setParentNode(father);
                }
            }
            countNode--;
            return true;
        }
    }

    @Override
    public E replace(E element, E newElement) {      
        NodeTreeBinary<E> p = ROOT;
        while (p != null) {
            if (element.compareTo(p.getElement()) == 0) {
                E elementPrevious = p.getElement();
                p.setElement(newElement);              
                return elementPrevious;
            }
            if (element.compareTo(p.getElement()) < 0) {
                p = p.getChildNodeLeft();
            } else {
                p = p.getChildNodeRight();
            }
        }
        return null;
    }

    @Override
    public boolean contains(E element) {
        return (getNodeElement(element) != null);
    }

    @Override
    public E retrieve(E element) {
        NodeTreeBinary<E> specificNode = getNodeElement(element);
        if(specificNode != null) {
            return specificNode.getElement();
        }
        return null;
    }

    @Override
    public IIterator<NodeTreeBinary<E>> iteratorNode() {
        return new IteratorNodeBinary();
    }

    @Override
    public IIterator<E> iteratorElement() {
        return new IteratorElement();
    }

    @Override
    public E getElementParent(E element) {
        NodeTreeBinary<E> specificNode = getNodeElement(element);
        if(specificNode != null) {
            return specificNode.getParentNode().getElement();
        }
        return null;
    }

    @Override
    public NodeTreeBinary<E> getNodeElement(E element) {
        NodeTreeBinary<E> p = ROOT;
        while (p != null) {
            if (element.compareTo(p.getElement()) == 0) {
                // Retorna o "nó" do Objeto passado como parâmetro
                return p;
            }
            if (element.compareTo(p.getElement()) < 0) {
                p = p.getChildNodeLeft();
            } else {
                p = p.getChildNodeRight();
            }
        }
        return null;
    }

    @Override
    public NodeTreeBinary<E> getNodeRoot() {
        NodeTreeBinary<E> p = ROOT;
        return p;
    }

    @Override
    public E getElementRoot() {
        NodeTreeBinary<E> p = ROOT;
        return p.getElement();
    }

    @Override
    public boolean isTreeEmpty() {
        return (countNode == 0);
    }

    @Override
    public int getSize() {
        return countNode;
    }

    @Override
    public void clear() {
        ROOT = null;
        countNode = 0;    
    }

    @Override
    public Object[] toArray() {
        if (isTreeEmpty()) {
            return null;
        }
        Object[] objs = new Object[countNode];
        IIterator<E> it = iteratorElement();
        int i = -1;
        Object obj = it.getFirst();
        while (obj != null) {
            i++;
            objs[i] = obj;
            obj = it.getNext();
        }
        return objs;
    }

    @Override
    public Object[] sort(Comparator<E> comparador) {
        if (countNode == 0) {
            return null;
        }
        Object[] obj = toArray();
        Sort.quickSort(obj, comparador);
        return obj;
    }
    
    @Override
    public void symmetric(NodeTreeBinary<E> node) {
        if(node != null) {
            symmetric(node.getChildNodeLeft());
            symmetric(node.getChildNodeRight());
        }
    }

    @Override
    public void preOrder(NodeTreeBinary<E> node) {
        if(node != null) {
            preOrder(node.getChildNodeLeft());
            preOrder(node.getChildNodeRight());
        }
    }
    
    @Override
    public void posOrder(NodeTreeBinary<E> node) {
        if(node != null) {
            posOrder(node.getChildNodeLeft());
            posOrder(node.getChildNodeRight());
        }
    }

    @Override
    public int getHeightNode(NodeTreeBinary<E> node) {
        int heightNode = 0;
        if (node != null) {  
            NodeTreeBinary<E> nodeTemp;
            
            Queue<NodeTreeBinary<E>> queue = new LinkedList<NodeTreeBinary<E>>();
            queue.offer(node);
         
            while (!queue.isEmpty()) {
                nodeTemp = queue.remove();
                heightNode = nodeTemp.height + 1;

                if (nodeTemp.getChildNodeLeft() != null) {
                    nodeTemp = nodeTemp.getChildNodeLeft();
                    nodeTemp.height = heightNode;
                    queue.offer(nodeTemp);
                }
                if (nodeTemp.getChildNodeRight() != null) {
                    nodeTemp = nodeTemp.getChildNodeRight();
                    nodeTemp.height = heightNode;
                    queue.offer(nodeTemp);
                }     
            }
            
            return heightNode - 1;
        }     
        return heightNode;
    }
    
    @Override
    public void balancingTree() {
        ArrayList<E> arrayList = new ArrayList<E>();      
        IIterator<E> it = this.iteratorElement();
        E obj = it.getFirst();
        
        int i = -1;
        while (obj != null) {
            i++;
            arrayList.add(obj);
            obj = it.getNext();
        }
        
        ROOT = null;
        int number = countNode - 1;
        countNode = 0;
        generateBalancingTree(arrayList, 0, number);
    }
    
    protected void generateBalancingTree(ArrayList<E> arrayList, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            add(arrayList.get(meio));
            generateBalancingTree(arrayList, inicio, meio - 1);
            generateBalancingTree(arrayList, meio + 1, fim);
        }
    }
    
    protected class IteratorElement implements IIterator<E> {
        private Queue<NodeTreeBinary<E>> queue;
        private NodeTreeBinary<E> nodePrevious;
        
        public IteratorElement(){
            this.queue = new LinkedList<NodeTreeBinary<E>>();
            this.nodePrevious = null;
        }

        private void symmetric(NodeTreeBinary<E> node) {
            if (node != null) {
                symmetric(node.getChildNodeLeft());
                queue.offer(node);
                symmetric(node.getChildNodeRight());
            }
        }

        @Override
        public E getFirst() {
            symmetric(ROOT);
            if (queue.isEmpty()) {
                return null;
            }
            nodePrevious = queue.remove();
            return nodePrevious.getElement();
        }

        @Override
        public E getNext() {
            if (queue.isEmpty()) {
                return null;
            }
            nodePrevious = queue.remove();
            return nodePrevious.getElement();
        }

        @Override
        public void remove() {
            removeNode(nodePrevious);
        }  
    }

    protected class IteratorNodeBinary implements IIterator<NodeTreeBinary<E>> {
        private Queue<NodeTreeBinary<E>> queue;
        private NodeTreeBinary<E> nodePrevious;
        
        public IteratorNodeBinary(){
            this.queue = new LinkedList<NodeTreeBinary<E>>();
            this.nodePrevious = null;
        }

        private void symmetric(NodeTreeBinary<E> node) {
            if (node != null) {
                symmetric(node.getChildNodeLeft());
                queue.offer(node);
                symmetric(node.getChildNodeRight());
            }
        }

        @Override
        public NodeTreeBinary<E> getFirst() {
            symmetric(ROOT);
            if (queue.isEmpty()) {
                return null;
            }
            nodePrevious = queue.remove();
            return nodePrevious;
        }

        @Override
        public NodeTreeBinary<E> getNext() {
            if (queue.isEmpty()) {
                return null;
            }
            nodePrevious = queue.remove();
            return nodePrevious;
        }

        @Override
        public void remove() {
            removeNode(nodePrevious);
        } 
    }    
  
}
