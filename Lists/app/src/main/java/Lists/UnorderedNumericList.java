package Lists;

//Aram Aprahamian
//Feb 07, 2024

public class UnorderedNumericList<T extends Number> implements NumericList<T> {

    T[] array;
    int numItems;

    public UnorderedNumericList() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public UnorderedNumericList(int size) {
        array = (T[]) new Number[size];
        numItems = 0;
    }

    /**
     * returns item at index
     * @return null if item does not exist;
     */
    public T get(int index) {
        if(index < 0 || index >= numItems)
            return null;

        return array[index];
    }

    /**
     * @return number of elements in the array;
     */
    public int size() {
        return numItems;
    }

    /**
     * @return true if array is full, false if not.
     */
    public boolean isFull() {
        return array.length == numItems;
    }

    /**
     * @return true if the array is empty, false if not.
     */
    public boolean isEmpty() {
        return numItems == 0;
    }

    /**
     * Inserts an object at the end of the array
     * @param item The item to insert
     */
    public void insert(T item) {
        if(item == null) return;

        if(isFull()){
            expand(array.length * 2);
        }

        array[numItems++] = item;
    }

    /**
     * Inserts an object at the specified index
     * @param index The index to insert the item
     * @param item The item to insert
     */
    public void insert(int index, T item) {
        if(item == null) return;

        if(isFull())
            expand(array.length * 2);

        if(index == numItems - 1)
            insert(item);

        for(int i = numItems + 1; i > index; i--) {
            array[i] = array[i-1];
        }

        array[index] = item;
        numItems++;
    }

    /**
     * removes the item from the scope of the list.
     * @param tItem The item to delete
     * @return true if item was deleted. false if not found.
     */
    public boolean delete(T tItem) {
        if(tItem == null || numItems == 0) return false;

        int i = search(tItem);
        if(i == -1) return false;
        else {
            if(i == numItems-1) expand(array.length * 2);

            //Shift the items down
            for(int j = i; j < numItems-1; j++) {
                array[j] = array[j + 1];
            }
        }

        numItems--;
        return true;
    }

    /**
     * Uses linear search to find the index of the item inside the array.
     * @param item the item to search for
     * @return index of the item in the list. Returns -1 if not found
     */
    public int search(T item) {
        if(item == null) {
            return -1;
        }

        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) break;
            if(array[i].equals(item)) return i;
        }
        return -1;
    }

    /**
     * Doubles the length of the array when the size overflows
     * @param length the new desired array length
     */
    @SuppressWarnings("unchecked")
    protected void expand(int length) {
        if(length < 0) {
            System.out.println("Length must be greater than 0!");
            return;
        }
        System.out.println("Expanding to length " + length);

        T[] resize = (T[]) new Number[length];
        for(int i = 0; i < numItems; i++) {
            resize[i] = array[i];
        }
        array = resize;
    }

    /**
     * Prints the values of the array in list format.
     */
    public void display() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < numItems; i++) {
            if(i == numItems - 1) {
                sb.append(array[i].toString());
            } else {
                sb.append(String.format("%s, ", array[i].toString()));
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

