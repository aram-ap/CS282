package Lists;

public interface NumericList<T extends Number> {

    /**
     * Returns item at index
     * @return null if item does not exist;
     */
    public T get(int index);

    /**
     * @return Number of elements in the array;
     */
    public int size();

    /**
     * @return True if array is full, false if not.
     */
    public boolean isFull();

    /**
     * @return True if the array is empty, false if not.
     */
    public boolean isEmpty();

    /**
     * Inserts an object at the end of the array
     * @param item The item to insert
     */
    public void insert(T item);

    /**
     * removes the item from the scope of the list.
     * @param item The item to delete
     * @return true if item was deleted. false if not found.
     */
    public boolean delete(T item);

    /**
     * Uses a searching algorithm to find the index of the inputted item.
     * @param item the item to search for
     * @return index of the item in the list. Returns -1 if not found
     */
    public int search(T item);

    /**
     * Prints the contents of the array in list format.
     */
    public void display();
}
