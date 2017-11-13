/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author malij6756
 */
public class IntNode {

    private int item;
    private IntNode next;
    
    public IntNode(int num) {
        item = num;
        next = null;
    }

    /**
     * Returns
     * @return the stored number
     */
    public int getNum(){
        return this.item;
    }
    
    
    /**
     * Returns the node that comes after
     * @return the next node
     */
    public IntNode getNext() {
        return this.next;
    }
    
    
    /**
     * Sets the node that comes after
     * @param node the node to point to
     */
    public void setNext(IntNode node) {
        this.next = node;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }
}