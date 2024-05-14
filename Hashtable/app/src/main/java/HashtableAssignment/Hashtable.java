package HashtableAssignment;

public class Hashtable
{
    private BST[] hashArray; // array of lists

    private int arraySize;

    // -------------------------------------------------------------
    public Hashtable(int size) // constructor
    {
        arraySize = size;
        hashArray = new BST[arraySize]; // create array
        for(int j=0; j<arraySize; j++) // fill array
            hashArray[j] = new BST(); // with lists
    }

    // -------------------------------------------------------------
    public void displayTable()
    {
        for(int j=0; j<arraySize; j++) // for each cell,
            {
                System.out.print(j + ". "); // display cell number
                hashArray[j].inorder(); // display list
                System.out.println();
        }
    }
    // -------------------------------------------------------------
    public int hashFunc(int key) // hash function
    {
        return key % arraySize;
    }
    // -------------------------------------------------------------
    public void insert(int key) // insert a link
    {
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].insert(key); // insert at hashVal
    } // end insert()
    // -------------------------------------------------------------
    public void delete(int key) // delete a link
    {
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].delete(key); // delete link
    } // end delete()
    // -------------------------------------------------------------
    public Node find(int key) // find link
    {
        int hashVal = hashFunc(key); // hash the key
        Node theLink = hashArray[hashVal].search(key); // get link
        return theLink; // return link
    }
    // -------------------------------------------------------------
} // end class HashTable
