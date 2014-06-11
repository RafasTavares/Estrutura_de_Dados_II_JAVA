
package com.project.collection;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("serial")
public class TreeBinaryDemon<E extends Comparable<E>> extends TreeBinary<E> {

    public TreeBinaryDemon() {
        super();
    }
    
    private class SupportPrintTree<E> {
        int height;
        int dimension;
        NodeTreeBinary<E> node;
    } 
    
    /**
     * Imprimi a arvore no console em forma de uma arvore binaria.
     * @param
     *      (NodeTreeBinary<E> node) : Seta um nó para imprimir sua arvores
     */ 
    public void printConsoleTree(NodeTreeBinary<E> node) {
        if (node == null) {
            return;
        }
        
        int heightNodePrevious = 0;
        int heightNode = 0;
        
        NodeTreeBinary<E> pTemp;
        
        String space = "                              ";         
        StringBuilder spaceInWhite = new StringBuilder();        
        spaceInWhite.append(space);
        spaceInWhite.append(space);
        spaceInWhite.append(space);
        spaceInWhite.append(space);
        
        int widthWindow  = 90;
        int dimension = widthWindow / 2;
        int offset;

        StringBuffer rowMain = new StringBuffer(200);
        String row = "";

        SupportPrintTree<E> supportPrint = new SupportPrintTree<E>();
        supportPrint.height = 0;
        supportPrint.dimension = dimension;
        supportPrint.node = node;
        
        Queue<SupportPrintTree<E>> queue = new LinkedList<SupportPrintTree<E>>();    
        queue.offer(supportPrint);

        while (!queue.isEmpty()) {
            supportPrint = queue.remove();
            dimension = supportPrint.dimension;
            pTemp = supportPrint.node;
            heightNode = supportPrint.height;

            if (heightNode == heightNodePrevious) {
                rowMain.append(
                    spaceInWhite.substring(0, dimension - rowMain.length()) +
                    pTemp.getElement().toString()
                );
                row = row + spaceInWhite.substring(0, dimension - row.length())
                          + pTemp.getElement().toString();
            } else {
                System.out.println(row + "\n\n");
                rowMain.setLength(0);
                rowMain.append(
                    spaceInWhite.substring(0, dimension) +
                    pTemp.getElement().toString()
                );
                row = spaceInWhite.substring(0, dimension) + pTemp.getElement().toString();                
                heightNodePrevious = heightNode;
            }
            heightNode = heightNode + 1;
            offset = (int) (widthWindow / Math.round(Math.pow(2, heightNode + 1)));
            if (pTemp.getChildNodeLeft()!= null) {
                supportPrint = new SupportPrintTree<E>();
                supportPrint.dimension = dimension - offset;
                supportPrint.height = heightNode;
                supportPrint.node = pTemp.getChildNodeLeft();
                queue.offer(supportPrint);
            }
            if (pTemp.getChildNodeRight()!= null) {
                supportPrint = new SupportPrintTree<E>();
                supportPrint.dimension = dimension + offset;
                supportPrint.height = heightNode;
                supportPrint.node = pTemp.getChildNodeRight();
                queue.offer(supportPrint);
            }
        }   
        System.out.println(rowMain);
    }  
  
}
