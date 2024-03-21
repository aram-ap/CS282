package CircularLinkedList;

import java.util.Random;

/**
 * Starter app for the circular linked list
 * @author Aram Aprahamian
 */
public class App {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        Random rand = new Random();

        cll.display(); //Testing display while list is empty
        cll.delete(); //Testing delete while list is empty

        //Testing insert function
        System.out.println("Inserting 10 items");
        for(int i = 0; i < 10; i++) {
            cll.insert(rand.nextInt(100));
        }
        var refList = cll.clone();

        //Testing display with elements in the list
        cll.display();
        System.out.println();

        //Testing delete function
        System.out.println("Deleting 3 items");
        System.out.println("Deleted: " + cll.delete());
        System.out.println("Deleted: " + cll.delete());
        System.out.println("Deleted: " + cll.delete());

        cll.display();
        System.out.println();

        //Testing step function
        System.out.println("Stepping through 3 items");
        cll.step();
        cll.display();
        cll.step();
        cll.display();
        cll.step();
        cll.display();

        System.out.println();

        //Testing insertion after doing some other actions
        cll.insert(-50);
        System.out.println("Inserted '-50'");
        cll.display();
        System.out.println();

        cll.insert(333);
        System.out.println("Inserted '333'");
        cll.display();
        System.out.println();

        //Testing search function
        System.out.println("Searching for '-50'");
        System.out.println("Got " + cll.search(-50)); //Searching with element inside the list
        System.out.println();

        System.out.println("Searching for '1204'");
        System.out.println("Got " + cll.search(1204)); //Searching while element is not in the list
        System.out.println();

        //Testing isEmpty() function and delete function
        while(!cll.isEmpty()) {
            System.out.println("Deleted: " + cll.delete());
        }

        //Display the emptied list
        cll.display();
        System.out.println("Cloned copy of the list after inserting initial 10 values:");
        refList.display();
    }
}
