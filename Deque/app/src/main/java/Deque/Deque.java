package Deque;

public class Deque {
    private int[] arr;
    protected int numItems;
    private int left = -1;
    private int right = 0;

    public Deque(int initCapacity) {
        arr = new int[initCapacity];
    }

    public Deque() {
        this(10);
    }

    public void insertLeft(int val) {
        if(isFull()) {
            System.out.println("Could not insert on left--Deque is full!");
            return;
        }

        if(--left < 0) {
            left = arr.length - 1;
        }

        arr[left] = val;
        numItems++;
    }

    public void insertRight(int val) {
        if(isFull()) {
            System.out.println("Could not insert on right--Deque is full!");
            return;
        }

        arr[right++] = val;
        numItems++;

        if(right == arr.length) {
            right = 0;
        }
    }

    public int deleteLeft() {
        if(isEmpty()) {
            System.out.println("Could not delete on left--Deque is empty!");
            return 0;
        }

        if(++left == arr.length) {
            left = 0;
        }
        int val = arr[left];
        numItems--;
        return val;
    }

    public int deleteRight() {
        if(isEmpty()) {
            System.out.println("Could not delete on right--Deque is empty!");
            return 0;
        }

        if(--right < 0) {
            right = arr.length - 1;
        }

        int val = arr[right];
        numItems--;
        return val;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public boolean isFull() {
        return numItems == arr.length;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if(isEmpty()) {
            return "[]";
        }

        str.append("[");
        for(int i = 0; i < numItems; i++) {
            int index = left + i;
            if(index >= arr.length) {
                index -= arr.length;
            }
        }

        int[] temp = new int[numItems];
        int index = 0;
        while(!isEmpty()){
            temp[index++] = deleteLeft();
        }

        for(int i = 0; i < temp.length; i++) {
            str.append(temp[i]);
            if(i != temp.length-1) {
                str.append(", ");
            }
            insertRight(temp[i]);
        }

        str.append("]");
        return str.toString();
    }
}
