/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Deque;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Deque deque = new Deque();

        System.out.println("Deque Insert/Delete Left: " + testDequeInsertLeft());
        System.out.println("Deque Insert/Delete Right: " + testDequeInsertRight());
        System.out.println("Deque test isEmpty: " + testDequeIsEmpty());
        System.out.println("Deque test isFull: " + testDequeIsFull());

        System.out.println("Stack Test: " + stackTest());
    }



    public static boolean testDequeInsertLeft() {
        int numItemsTest1 = 100;
        Random random = new Random();
        Deque deque1 = new Deque(numItemsTest1);
        int[] refArray1 = new int[numItemsTest1];

        for(int i = 0; i < numItemsTest1; i++) {
            int val = random.nextInt(1000);
            deque1.insertLeft(val);
            refArray1[i] = val;
        }

        // System.out.println(deque1.toString());
        // printArr(refArray1);

        for(int val : refArray1) {
            int d = deque1.deleteRight();
            // System.out.println("Val: " + val + ", deque: " + d);
            if(val != d) return false;
        }

        return true;
    }

    public static boolean testDequeInsertRight() {
        int numItemsTest1 = 100;
        Random random = new Random();
        Deque deque1 = new Deque(numItemsTest1);
        int[] refArray1 = new int[numItemsTest1];

        for(int i = 0; i < numItemsTest1; i++) {
            int val = random.nextInt(1000);
            deque1.insertRight(val);
            refArray1[i] = val;
        }

        // System.out.println(deque1.toString());
        // printArr(refArray1);

        for(int val : refArray1) {
            if(val != deque1.deleteLeft()) return false;
        }

        return true;
    }


    public static boolean testDequeIsEmpty() {
        Deque deque = new Deque(0);
        if(!deque.isEmpty()) {
            return false;
        }

        Deque deque2 = new Deque();
        if(!deque2.isEmpty()) {
            return false;
        }

        Deque deque3 = new Deque();
        for(int i = 0; i < 10; i++){
            deque3.insertRight(new Random().nextInt(10));
        }
        for(int i = 0; i < 10; i++) {
            deque3.deleteRight();
        }
        return deque3.isEmpty();
    }

    public static boolean testDequeIsFull() {
        Deque deque = new Deque(10);
        for(int i = 0; i < 10; i++) {
            deque.insertLeft(new Random().nextInt(10));
        }
        return deque.isFull();
    }

    public static boolean stackTest() {
        int numItemsTest1 = 100;
        Random random = new Random();
        Stack stack1 = new Stack(numItemsTest1);
        int[] refArray1 = new int[numItemsTest1];

        for(int i = 0; i < numItemsTest1; i++) {
            int val = random.nextInt(1000);
            stack1.push(val);
            refArray1[i] = val;
        }

        // System.out.println(stack1.toString());
        // printArr(refArray1);

        for(int i = numItemsTest1-1; i >= 0; i--) {
            if(refArray1[i] != stack1.pop()) return false;
        }

        return true;
    }

    public static void printArr(int[] arr) {
        StringBuilder str = new StringBuilder();

        str.append("[");
        for(int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
            if(i != arr.length - 1) {
                str.append(", ");
            }
        }

        str.append("]");
        System.out.println(str.toString());
    }
}