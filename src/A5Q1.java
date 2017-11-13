/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malij6756
 */
public class A5Q1 {

    private IntNode head;
    private int numItems;

    public A5Q1() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {

        int counter = 0;
        // start at the beginning
        IntNode node = head;

        // if there's nothing in the list
        if (node == null) {
            IntNode temp = new IntNode(num);
            head = temp;
            // if the added number is the largest, add to the end
        } else if (num > get(numItems - 1)) {
            // travel to the end
            while (node.getNext() != null) {
                // travel to the next node
                node = node.getNext();
            }
            // create the new node
            IntNode temp = new IntNode(num);
            // insert it into the list
            node.setNext(temp);

            // if the number is the lowest in the list
        } else if (num < node.getNum()) {
            // create the node
            IntNode temp = new IntNode(num);
            // the new node prints to the start
            temp.setNext(head);
            // reassign the head node
            head = temp;

            // if the number fits somewhere in the middle of the list
        } else {
            // counts up until it finds a number greater than itself
            while (num > node.getNext().getNum()) {
                node = node.getNext();
                // adds to a counter to mark the position
                counter++;
            }
            // resets the node back to the start
            node = head;
            // finds the specific spot
            for (int i = 0; i < counter - 1; i++) {
                node = node.getNext();
            }

            // @ node just before the insert
            IntNode temp = new IntNode(num);
            // create the afterlink first!
            temp.setNext(node.getNext());
            // change the node pointer
            node.setNext(temp);
        }

        // increase item counter
        numItems++;
    }

    // returns the size of the list
    public int size() {
        return numItems;
    }
// returns whether or not the list is empty

    public boolean isEmpty() {
        return numItems == 0;
    }
// returns the number at the requested position

    public int get(int position) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    // finds and removes the number inputted
    public void remove(int num) {

        IntNode node = head;
        // if removing from the start
        if (node.getNum() == num) {
            head = head.getNext();
        } // removing from the end
        else if (num == get(numItems - 1)) { // LAST EDIT HERE
            // moving to the second last item
            for (int i = 0; i < numItems - 1; i++) {
                node = node.getNext();
            }
            // sever the link
            node.setNext(null);

        } else {
            node = head;
            // travels up the nodes until it finds the node before the one with the number needed
            while (num != node.getNext().getNum()) {
                node = node.getNext();
            }
            // the node to remove
            IntNode toRemove = node.getNext();
            // its next node
            IntNode next = toRemove.getNext();
            // set all the links
            node.setNext(next);
            toRemove.setNext(null);
        }
        // shrinks the array
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A5Q1 list = new A5Q1();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(2);
        list.remove(4);
        //list.add(1, 13);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
