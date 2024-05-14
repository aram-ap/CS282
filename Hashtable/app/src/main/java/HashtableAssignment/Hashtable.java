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
    public void insert(Student s) // insert a link
    {
        int hashVal = hashFunc(s.id); // hash the key
        hashArray[hashVal].insert(s); // insert at hashVal
    } // end insert()
    // -------------------------------------------------------------
    public void delete(int id) // delete a link
    {
        int hashVal = hashFunc(id); // hash the key
        hashArray[hashVal].delete(id); // delete link
    } // end delete()
    // -------------------------------------------------------------
    public Node find(int id) // find link
    {
        int hashVal = hashFunc(id); // hash the key
        Node node = hashArray[hashVal].search(id); // get link
        return node; // return link
    }
    // -------------------------------------------------------------
} // end class HashTable
