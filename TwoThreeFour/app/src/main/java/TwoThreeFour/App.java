/*
 * This source file was generated by the Gradle 'init' task
 */
package TwoThreeFour;

public class App {

    public static void main(String[] args) {
        Tree234 t = new Tree234();
        t.insert(40);
        t.insert(20);
        t.insert(50);
        t.insert(25);
        t.insert(4);
        t.insert(43);
        t.insert(41);
        t.insert(21);
        t.insert(51);
        t.insert(26);
        t.insert(5);
        t.insert(44);

        //Delete method marks the node containing the key as
        t.delete(43);
        System.out.println(t.search(20));
        t.inorderTraversal();
    }
}
