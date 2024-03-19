/**
 *  @author Aram Aprahamian
 *  @since February 19, 2024
 */
package Lists;

public class OrderedNumericList<T extends Number> implements NumericList<T> {
    T[] array;
    int numItems;

    public OrderedNumericList() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public OrderedNumericList(int size) {
        array = (T[]) new Number[size];
        numItems = 0;
    }

    /**
     *  Merges two ordered lists in sorted order.
     *  @param aList The list to merge in the source list
     */
    @SuppressWarnings("unchecked")
    public T[] merge(OrderedNumericList<T> aList) {
        if(aList == null || aList.size() == 0) return null;

        T[] merged = (T[]) new Number[this.size() + aList.size()];

        //srcInd is the index for aList; targetInd the index for this object
        int listInd = 0, srcInd = 0, targetInd = 0;
        while(srcInd < aList.size() && targetInd < this.size()) {
            if(aList.get(srcInd).doubleValue() > this.get(targetInd).doubleValue()) {
                merged[listInd++] = this.get(targetInd++);
            } else {
                merged[listInd++] = aList.get(srcInd++);
            }
        }

        while(srcInd < aList.size()) {
            merged[listInd++] = aList.get(srcInd++);
        }

        while(targetInd < this.size()) {
            merged[listInd++] = this.get(targetInd++);
        }

        this.array = merged;
        this.numItems = merged.length;
        return merged;
    }

    /**
     * Inserts an item in the list using Binary search
     * @param item The item to insert
     */
    @Override
    public void insert(T item) {
        if(item == null) return;

        // Dynamically expands the list if numbers exceed list size.
        if(isFull() || numItems+1 > array.length) {
            expand(array.length * 2);
        }
        else if(isEmpty()) {
            array[0] = item;
            numItems++;
            return;
        }

        int i = 0;
        int low = 0, high = array.length-1;
        while(true) {
            int mid = (high+low)/2;

            if(array[mid] == null) {
                high = mid-1;
                if (low > high) {
                    i = mid;
                    break;
                }
                continue;
            }

            // Check if item is in middle
            if(array[mid].equals(item)){
                i = mid;
                break;
            }
            else if (low > high) {
                i = low;
                break;
            }
            else {
                if(array[mid].doubleValue() < item.doubleValue())
                    low = mid+1;
                else
                    high = mid-1;
            }
        }

        //Shift all items to the right
        for (int j = numItems; j > i; j--) {
            array[j] = array[j - 1];
        }

        array[i] = item;
        numItems++;
    }

    /**
     * Uses binary search to find the index of the item inside the array.
     * @param item the item to search for
     * @return index of the item in the list. Returns -1 if not found
     */
    @Override
    public int search(T item) {
        if(item == null || isEmpty()) return -1;

        int low = 0, high = numItems-1;
        while(true) {
            int mid = (high-low)/2;

            if(array[mid] == null) {
                high--;
                continue;
            }

            // Check if item is in middle
            if(array[mid].equals(item))
                return mid;
            else if (low > high)
                return -1;
            else {
                if(array[mid].doubleValue() < item.doubleValue())
                    low = mid + 1;
                else
                    high = mid-1;
            }
        }
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
}
