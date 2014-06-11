/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author 10361
 */
public interface Item {
    public int compata(Item it);
    public void alteraChave(Object chave);
    public Object recuperaChave();
}
