
package com.project.collection;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

import com.project.collection.interfaces.ITreeGeneric;
import com.project.collection.interfaces.IIterator;

@SuppressWarnings("serial")
public class TreeGeneric<E extends Comparable<E>> implements Serializable, ITreeGeneric<E> {

    protected NodeTree<E> ROOT;
    protected int size;
    
    public TreeGeneric() {
        ROOT = null;
        size = 0;
    }
    
    @Override
    public E add(E elementParent, E element) {          
        NodeTree<E> parentNode = getNodeElement(elementParent);
        NodeTree<E> newNode = new NodeTree<E>(parentNode, element);  
        if (parentNode == null) {
            ROOT = newNode; 
            return ROOT.getElement();
        } else {
            if(contains(element) != true) {  
                int position =+ parentNode.getSizeChildren();               
                parentNode.setChildNode(position, newNode);  
                return parentNode.getChildNode(position).getElement();
            }  
        }      
        return null;       
    }

    @Override
    public E remove(E specificElement) {
        NodeTree<E> specificNode = getNodeElement(specificElement);   
        if(specificNode != null) {
            return removeNode(specificNode).getElement();
        }
        return null;
    }

    private NodeTree<E> removeNode(NodeTree<E> specificNode) {
        if(specificNode != null) {  
            if(specificNode.isRoot() != true) {
                NodeTree<E> parentNode = specificNode.getParentNode(); 
                boolean remove = parentNode.getChildren().remove(specificNode);
                if(remove == true) {        
                    return specificNode;
                }
            } else {
                ROOT = null;
                return specificNode;
            }
        }
        return null;   
    }

    @Override
    public E replace(E element, E newElement) {
        NodeTree<E> nodeOrigin = getNodeElement(element);
        if(nodeOrigin != null) {
            E elementOrigin = nodeOrigin.getElement();
            nodeOrigin.setElement(newElement);
            return elementOrigin;
        }
        return null;
    }

    @Override
    public boolean contains(E element) {
        NodeTree<E> node = getNodeElement(element);
        if(node != null) {
            return true;
        }
        return false;
    }

    @Override
    public E retrieve(E element) {
        NodeTree<E> node = getNodeElement(element);
        if(node != null) {
            return node.getElement();
        }
        return null;
    }

    @Override
    public IIterator<NodeTree<E>> iteratorNode() {
        return new IteratorNode();
    }
    
    @Override
    public IIterator<E> iteratorElement() {
        return new IteratorElement();
    }
    
    @Override
    public E getElementParent(E element) {
        NodeTree<E> node = getNodeElement(element);
        if(node != null && node.isRoot() == false) {
            return node.getParentNode().getElement();
        } 
        return null;
    }

    @Override
    public NodeTree<E> getNodeElement(E element) {
        if(element != null) {
            IIterator<NodeTree<E>> it = iteratorNode();
            NodeTree<E> objNode = it.getFirst();
            while (objNode != null) {
                if(objNode.getElement().compareTo(element) == 0) {
                    return objNode;
                }
                objNode = it.getNext();
            }
        } 
        return null;
    }

    @Override
    public NodeTree<E> getNodeRoot() {
        IIterator<NodeTree<E>> it = iteratorNode();
        NodeTree<E> objNode = it.getFirst();
        while (objNode != null) {
            if(objNode.isRoot() == true) {
                return objNode;
            }  
            objNode = it.getNext();
        }
        return null;
    }

    @Override
    public E getElementRoot() {
        NodeTree<E> node = getNodeRoot();
        if(node != null) {
            return node.getElement();
        }
        return null;
    }

    @Override
    public boolean isTreeEmpty() {
        if(ROOT == null) {
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        if(ROOT != null) {    
            size = 0;  
            IIterator<NodeTree<E>> it = iteratorNode();
            NodeTree<E> nodeNext = it.getFirst();
            while (nodeNext != null) {
                size++;
                nodeNext = it.getNext();
            } 
            return size;
        }
        return 0;
    }

    @Override
    public void clear() {
        ROOT = null; 
    }

    @Override
    public Object[] toArray() {
        if(isTreeEmpty() != true) {
            Object[] objs = new Object[getSize()];
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
        return null;
    }   
    
    protected class IteratorElement implements IIterator<E> {

        private Queue<NodeTree<E>> queue;
        private NodeTree<E> pointer;
        
        public IteratorElement(){
            this.queue = new LinkedList<NodeTree<E>>();
            this.pointer = null;
        }

        private void symmetric(NodeTree<E> node) {
            if (node != null) {
                queue.offer(node);
                if(node.isEmptyChildren() != true) {
                    java.util.Iterator<NodeTree<E>> itr = node.getChildren().iterator();      
                    while(itr.hasNext()) {
                       NodeTree<E> nodeElement = itr.next();                       
                       symmetric(nodeElement);
                    }
                }
            }
        }

        @Override
        public E getFirst() {
            symmetric(ROOT);
            if (queue.isEmpty()) {
                return null;
            }
            pointer = queue.remove();
            return pointer.getElement();
        }

        @Override
        public E getNext() {
            if (queue.isEmpty()) {
                return null;
            }
            pointer = queue.remove();
            return pointer.getElement();
        }

        @Override
        public void remove() {
            removeNode(pointer);            
        }
    }
    
    protected class IteratorNode implements IIterator<NodeTree<E>> {

        private Queue<NodeTree<E>> queue;
        private NodeTree<E> pointer;

        public IteratorNode(){
            this.queue = new LinkedList<NodeTree<E>>();
            this.pointer = null;
        }
        
        private void symmetric(NodeTree<E> node) {
            if (node != null) {   
                queue.offer(node);
                if(node.isEmptyChildren() != true) {
                    java.util.Iterator<NodeTree<E>> itr = node.getChildren().iterator();      
                    while(itr.hasNext()) {
                       NodeTree<E> nodeElement = itr.next();                       
                       symmetric(nodeElement);
                    }
                }
            }
        }

        @Override
        public NodeTree<E> getFirst() {
            symmetric(ROOT);
            if (queue.isEmpty()) {
                return null;
            }
            pointer = queue.remove();
            return pointer;
        }

        @Override
        public NodeTree<E> getNext() {
            if (queue.isEmpty()) {
                return null;
            }
            pointer = queue.remove();
            return pointer;
        }

        @Override
        public void remove() {
            removeNode(pointer);            
        }
    }

}
