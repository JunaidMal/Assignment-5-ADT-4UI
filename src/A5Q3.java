/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;

/**
 *
 * @author junai
 */
public class A5Q3 {

    // store all of the integers on the stack
    private char[] stack;
    // keep track of how many items
    private int numItems;

    public A5Q3() {
        stack = new char[0];
        numItems = 0;
    }

    public boolean inLang(String word) {
        Stack<Character> stack = new Stack<Character>();
        // these 2 strings will hold the 2 words when they are compared at the end 
        String properWord = "";
        String reverseWord = "";

        // the amount of numbers in the array will be half the word (rounds down to 1)
        numItems = word.length() / 2;

        // checks if the word is even formatted properly with the $ in the middle of 2 same-length words
        if (word.charAt(word.length() / 2) != '$') {
            return false;
            // if the words are formatted properly
        } else {
            // puts the first half of the word into a stack
            for (int i = 0; i < word.length() / 2; i++) {
                stack.push(word.charAt(i));
            }
            // when the word is popped back out, it's in opposite order (just what we wanted)
            for (int i = 0; i < word.length() / 2; i++) {
                properWord += stack.pop();
            }
            // seperates the other half of the word for comparison
            reverseWord = word.substring((word.length() / 2) + 1, word.length());

            // compares both words, if they're the same then returns true
            if (reverseWord.equals(properWord)) {
                return true;
                // of not the same, returns false
            } else {
                return false;
            }

        }

    }

    public void push(char letter) {
        // if there is room in the stack
        if (numItems < stack.length) {
            // put the item on the stack
            stack[numItems] = letter;
            numItems++;
        } else {
            // make more room
            char[] temp = new char[stack.length * 2];
            // copy items over
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            // stack becomes new array
            stack = temp;
            // add item
            stack[numItems] = letter;
            numItems++;
        }
    }

    public int pop() {
        // get the top item on the stack
        // -1 because the array starts from 0, not 1 and the numItems doesn't track according to that
        char item = stack[numItems - 1];
        // one less item
        numItems--;
        // give back item 
        return item;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A5Q3 test = new A5Q3();

        System.out.println("Is word proper?: " + test.inLang("cat$tac"));
    }

}
