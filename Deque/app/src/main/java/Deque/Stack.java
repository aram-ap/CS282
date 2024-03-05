package Deque;

public class Stack extends Deque {

    public Stack(int initCapacity) {
        super(initCapacity);
    }

    public Stack() {
        this(10);
    }

    public void push(int val) {
        if(isFull()) {
            System.out.println("Push could not be completed--Stack is full!");
            return;
        }

        insertRight(val);
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Pop could not be completed--Stack is empty!");
            return 0;
        }

        return deleteRight();
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Peek could not be completed--Stack is empty!");
            return 0;
        }

        int val = deleteRight();
        insertRight(val);
        return val;
    }

    public String toString() {
        if(isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        int[] temp = new int[numItems];

        int index = 0;
        while(!isEmpty()){
            int val = pop();
            temp[index++] = val;
        }

        for(int i = temp.length-1; i >= 0; i--) {
            sb.append(temp[i]);
            if(i != 0) {
                sb.append(", ");
            }
            push(temp[i]);
        }

        return sb.toString();
    }
}
