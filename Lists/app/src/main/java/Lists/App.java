package Lists;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.lang3.ArrayUtils;

/**
 *  @author Aram Aprahamian
 *  @since February 19, 2024
 */
public class App {
    public static void main(String[] args) {
        int minNum = -100, maxNum = 100, maxSize = 10;
        System.out.println("Starting...");

        Random rand = new Random();
        ArrayList<Integer> ref = new ArrayList<Integer>();

        OrderedNumericList<Integer> list1 = new OrderedNumericList<>(10);
        OrderedNumericList<Integer> list2 = new OrderedNumericList<>(); //List can automatically resize

        int list1Size = rand.nextInt(maxSize) + 1; //This will demonstrate that size is independent of functionality
        int list2Size = rand.nextInt(maxSize) + 1;

        //Randomize the list
        for(int i = 0; i < list1Size; i++) {
            int randNum = (int) (rand.nextDouble() * (maxNum - minNum) + minNum);
            list1.insert(randNum);
            ref.add(randNum);
        }

        System.out.print("List1: ");
        list1.display();

        for(int i = 0; i < list2Size; i++) {
            int randNum = (int) (rand.nextDouble() * (maxNum - minNum) + minNum);
            list2.insert(randNum);
            ref.add(randNum);
        }
        System.out.print("List2: ");
        list2.display();

        //Merge list2 into list1
        list1.merge(list2);
        ref.sort(Comparator.naturalOrder());

        System.out.println("\nReference: ");
        System.out.println(ArrayUtils.toString(ref));

        System.out.println("\nMerged list: ");
        list1.display();

        //Check size of reference array and the merged array
        if(list1.size() != ref.size()) {
            System.out.println("FAILED SIZE CHECK");
            return;
        }

        //Check if all numbers are equal
        for(int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(ref.get(i))) {
                System.out.println("NUMBERS NOT EQUAL! list1: " + list1.get(i) + ", ref: " + ref.get(i) + " at index " + i + "!");
                return;
            }
        }

        System.out.println("Completed successfully!");
    }
}
