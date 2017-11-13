/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junai
 */
public class A5Q2 {

    // JUST A NOTE I DON'T KNOW WHY BUT I FELT LIKE LEAVING ONE
    // The way I understood the instructions were that when a number is added,
    // the array would shift the numbers down from the location of the new number
    // soooo ya
    // store all of the integers on the stack
    private int[] stack;
    // keep track of how many items
    private int numItems;

    public A5Q2() {
        stack = new int[10];
        numItems = 0;
    }

    public void add(int index, int num) {

        // if the array is already at maximum capacity
        if (numItems >= stack.length) {
            // num of items increased beforehand due to code needing the total amount after the number is added
            numItems++;

            // make more room by doubling the size
            int[] temp = new int[stack.length * 2];

            // copying all the numbers before the index of the number being added
            for (int i = 0; i < index; i++) {
                temp[i] = stack[i];
            }
            // adding the number at the index the user inputted
            temp[index] = num;

            // copying the rest of the numbers that occur AFTER the index of the number added
            for (int i = index + 1; i < numItems - index + 2; i++) {
                temp[i] = stack[i - 1];
            }
            // copying back to original array with new array
            stack = temp;
        } // this occurs if the array has enough room already to hold the new number
        else {
            //  num of items increased beforehand due to code needing the total amount after the number is added
            numItems++;

            // make an array to copy over onto
            int[] temp = new int[stack.length];

            // copying all numbers before the index of the new number that has to be added
            for (int i = 0; i < index; i++) {
                temp[i] = stack[i];
            }

            // adding the new number in the position it's supposed to go to
            temp[index] = num;

            // copying the rest of the array AFTER the new number 
            for (int i = index + 1; i < numItems - index + 2; i++) {
                temp[i] = stack[i - 1];
            }
            // copying new array onto old
            stack = temp;

        }

    }
    // removing a number at a certain position

    public void remove(int index) {
        // holder array
        int temp[] = new int[stack.length];

        // numbers before the index being removed are copied over
        for (int i = 0; i < index; i++) {
            temp[i] = stack[i];
        }

        // numbers after the index that was "removed" are copied over in a fashion the number at the index doesn't exist
        for (int i = index + 1; i < stack.length - 1; i++) {
            temp[i - 1] = stack[i];
        }

        // array is copied over to original 
        stack = temp;

        // The numItems isn't changed nor is the array shrunk due to instructions
    }

    // returns the size of the list
    public int size() {
        return numItems;
    }

    // returns the number at index requested in the array
    public int get(int index) {
        return this.stack[index];
    }
    // returns whether array is empty or not
    public boolean isEmpty() {
        // if numItems is 0 then return true, else false;
        return numItems == 0;
    }

    {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        A5Q2 stack = new A5Q2();

        stack.add(0, 0);
        stack.add(1, 1);
        stack.add(2, 2);
        stack.add(3, 3);
        stack.add(4, 4);
        stack.add(5, 5);
        stack.add(6, 6);
        stack.add(7, 7);
        stack.add(8, 8);
        stack.add(9, 9);
        stack.add(2, 20);

        stack.remove(2);

        for (int i = 0; i < stack.size(); i++) {
            System.out.println("Index: " + i + " Number: " + stack.get(i));
        }

    }
}
