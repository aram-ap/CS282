package Lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class OrderedNumericListTest {
    int minNum = -100, maxNum = 100, maxSize = 10;

    @Test
    void orderedInsert() {
        Random rand = new Random();
        ArrayList<Integer> ref = new ArrayList<Integer>();
        int list1Size = rand.nextInt(maxSize) + 1; //This will demonstrate that size is independent of functionality

        OrderedNumericList<Integer> list1 = new OrderedNumericList<>(10);
        //Randomize the list
        for(int i = 0; i < list1Size; i++) {
            int randNum = (int)(rand.nextDouble() * (maxNum - minNum)) + minNum;
            list1.insert(randNum);
            ref.add(randNum);
        }

        ref.sort(Comparator.naturalOrder());

        //Check if all numbers are equal
        for(int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(ref.get(i))) {
                assertEquals(list1.get(i), ref.get(i));
                return;
            }
        }
        assertTrue(true);
    }

    @Test
    void mergeTest() {
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

        for(int i = 0; i < list2Size; i++) {
            int randNum = (int) (rand.nextDouble() * (maxNum - minNum) + minNum);
            list2.insert(randNum);
            ref.add(randNum);
        }

        list1.merge(list2);
        ref.sort(Comparator.naturalOrder());

        //Check size of reference array and the merged array
        if(list1.size() != ref.size()) {
            assertFalse(true);
            return;
        }

        //Check if all numbers are equal
        for(int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(ref.get(i))) {
                assertFalse(true);
                return;
            }
        }
    }
}
