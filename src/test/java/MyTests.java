import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {
    LinearProbingHash LPHtable = new LinearProbingHash();

    @Test
    public void testLPHInsertion() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(11);
        LPHtable.insert(26);
        LPHtable.insert(34);

        int[] testArr = {0, 11, 0, 3, 34, 5, 26, 7, 0, 0};
        assertArrayEquals(testArr, LPHtable.arr);
    }

    @Test
    public void testLPHInsertionWithCollisions() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(11);
        LPHtable.insert(26);
        LPHtable.insert(34);

        LPHtable.insert(21);
        LPHtable.insert(36);
        LPHtable.insert(49);

        int[] testArr = {0, 11, 21, 3, 34, 5, 26, 7, 36, 49};
        assertArrayEquals(testArr, LPHtable.arr);
    }

    @Test
    public void testLPHInsertionWithWraparound() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(11);
        LPHtable.insert(26);
        LPHtable.insert(34);

        LPHtable.insert(21);
        LPHtable.insert(36);
        LPHtable.insert(49);

        LPHtable.insert(31);

        int[] testArr = {31, 11, 21, 3, 34, 5, 26, 7, 36, 49};
        assertArrayEquals(testArr, LPHtable.arr);
    }

    @Test
    public void testLPHSearch() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(11);
        LPHtable.insert(26);
        LPHtable.insert(34);

        LPHtable.insert(21);
        LPHtable.insert(36);
        LPHtable.insert(49);

        LPHtable.insert(31);

        assertTrue(LPHtable.search(31));
        assertTrue(LPHtable.search(11));
        assertTrue(LPHtable.search(21));
        assertTrue(LPHtable.search(3));
        assertFalse(LPHtable.search(131));
        assertFalse(LPHtable.search(226));
        assertFalse(LPHtable.search(2));
        assertFalse(LPHtable.search(4));
    }

    @Test
    public void testLPHDeletion() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(11);
        LPHtable.insert(26);
        LPHtable.insert(34);

        LPHtable.insert(21);
        LPHtable.insert(36);
        LPHtable.insert(36);
        LPHtable.insert(49);

        LPHtable.insert(31);

        LPHtable.delete(11);
        LPHtable.delete(36);
        LPHtable.delete(100);


        int[] testArr = {31, -1, 21, 3, 34, 5, 26, 7, -1, 49};
        assertArrayEquals(testArr, LPHtable.arr);
    }

    @Test
    public void testLPHInsertionAndSearchAfterDeletion() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(11);
        LPHtable.insert(26);
        LPHtable.insert(34);

        LPHtable.insert(21);
        LPHtable.insert(36);
        LPHtable.insert(49);

        LPHtable.insert(31);

        LPHtable.delete(11);
        LPHtable.delete(36);
        LPHtable.delete(100);

        assertTrue(LPHtable.search(31));
        assertFalse(LPHtable.search(36));

        LPHtable.insert(11);

        int[] testArr = {31, 11, 21, 3, 34, 5, 26, 7, -1, 49};
        assertArrayEquals(testArr, LPHtable.arr);
    }

    @Test
    public void testLPHInsertionRehashes() {
        LPHtable.insert(5);
        LPHtable.insert(7);
        LPHtable.insert(7);
        LPHtable.insert(3);
        LPHtable.insert(26);
        LPHtable.insert(34);

        LPHtable.insert(21);
        LPHtable.insert(49);

        LPHtable.insert(31);
        LPHtable.insert(11);

        LPHtable.insert(8);
        LPHtable.insert(52);

        int[] testArr = {0, 21, 0, 3, 0, 5, 26, 7, 8, 49, 0, 31, 11, 52, 34, 0, 0, 0, 0, 0};
        assertArrayEquals(testArr, LPHtable.arr);
    }


    SeparateChainingHash SCHtable = new SeparateChainingHash();
    IntLinkedList[] testList = new IntLinkedList[10];

    @Test
    public void testSCHInsert() {
        SCHtable.insert(5);
        SCHtable.insert(7);
        SCHtable.insert(7);
        SCHtable.insert(3);
        SCHtable.insert(11);
        SCHtable.insert(26);
        SCHtable.insert(34);

        for (int i = 0; i < 10; i++){
            testList[i] = new IntLinkedList();
        }
        testList[1].insert(11);
        testList[3].insert(3);
        testList[4].insert(34);
        testList[5].insert(5);
        testList[2].insert(26);
        testList[7].insert(7);

        assertTrue(linkedListsEqual(SCHtable.arr,testList), "Expected " + SCHtable.arr.toString() + " but got " + testList.toString());
    }

    @Test
    public void testSCHSearch() {
        SCHtable.insert(5);
        SCHtable.insert(7);
        SCHtable.insert(7);
        SCHtable.insert(3);
        SCHtable.insert(11);
        SCHtable.insert(26);
        SCHtable.insert(34);

        assertTrue(SCHtable.search(5));
        assertTrue(SCHtable.search(11));
        assertTrue(SCHtable.search(26));
        assertTrue(SCHtable.search(3));
        assertFalse(SCHtable.search(131));
        assertFalse(SCHtable.search(226));
        assertFalse(SCHtable.search(2));
        assertFalse(SCHtable.search(4));
    }

    @Test
    public void testSCHDeletion() {
        SCHtable.insert(5);
        SCHtable.insert(7);
        SCHtable.insert(3);
        SCHtable.insert(7);
        SCHtable.insert(11);
        SCHtable.insert(26);
        SCHtable.insert(34);
        SCHtable.insert(34);

        SCHtable.delete(11);
        SCHtable.delete(34);
        SCHtable.delete(100);

        for (int i = 0; i < 10; i++){
            testList[i] = new IntLinkedList();
        }
        testList[1].insert(11);
        testList[3].insert(3);
        testList[4].insert(34);
        testList[5].insert(5);
        testList[6].insert(26);
        testList[7].insert(7);

        testList[1].delete(11);
        testList[4].delete(34);

        assertTrue(linkedListsEqual(SCHtable.arr,testList), "Expected " + SCHtable.arr.toString() + " but got " + testList.toString());
    }

    @Test
    public void testSCHResize() {
        SCHtable.insert(5);
        SCHtable.insert(7);
        SCHtable.insert(3);
        SCHtable.insert(7);
        SCHtable.insert(11);
        SCHtable.insert(26);
        SCHtable.insert(34);

        SCHtable.delete(11);
        SCHtable.delete(34);
        SCHtable.delete(100);

        SCHtable.insert(20);
        SCHtable.insert(21);
        SCHtable.insert(42);
        SCHtable.insert(44);
        SCHtable.insert(49);
        SCHtable.insert(34);
        SCHtable.insert(16);

        IntLinkedList[] testList = new IntLinkedList[20];
        for (int i = 0; i < 20; i++){
            testList[i] = new IntLinkedList();
        }

        testList[0].insert(20);
        testList[1].insert(21);
        testList[2].insert(42);
        testList[3].insert(3);
        testList[4].insert(44);
        testList[5].insert(5);
        testList[6].insert(26);
        testList[7].insert(7);
        testList[9].insert(49);
        testList[13].insert(53);
        testList[14].insert(34);
        testList[16].insert(16);

        assertTrue(linkedListsEqual(SCHtable.arr,testList), "Expected " + Arrays.toString(SCHtable.arr) + " but got " + Arrays.toString(testList));
    }

    @Test
    public void testSCHDuplicates() {
        SCHtable.insert(5);
        SCHtable.insert(7);
        SCHtable.insert(7);
        SCHtable.insert(3);
        SCHtable.insert(11);
        SCHtable.insert(26);
        SCHtable.insert(34);

        SCHtable.delete(11);
        SCHtable.delete(34);
        SCHtable.delete(100);

        SCHtable.insert(20);
        SCHtable.insert(21);
        SCHtable.insert(42);
        SCHtable.insert(44);
        SCHtable.insert(49);
        SCHtable.insert(34);
        SCHtable.insert(16);

        SCHtable.insert(21);
        SCHtable.insert(16);

        IntLinkedList[] testList = new IntLinkedList[20];
        for (int i = 0; i < 20; i++){
            testList[i] = new IntLinkedList();
        }
        testList[3].insert(3);
        testList[5].insert(5);
        testList[6].insert(26);
        testList[7].insert(7);

        testList[0].insert(20);
        testList[1].insert(21);
        testList[2].insert(42);
        testList[3].insert(3);
        testList[4].insert(44);
        testList[5].insert(5);
        testList[6].insert(26);
        testList[7].insert(7);
        testList[9].insert(49);
        testList[13].insert(53);
        testList[14].insert(34);
        testList[16].insert(16);

        assertTrue(linkedListsEqual(SCHtable.arr,testList), "Expected " + SCHtable.arr.toString() + " but got " + testList.toString());
    }

    public boolean linkedListsEqual(IntLinkedList[] list1, IntLinkedList[] list2){
        for (int i = 0; i < list1.length; i++){
            // each spot in the array is a linked list, so we need to compare each linked list
            while (list1[i].head != null && list2[i].head != null){
                if (list1[i].head.data != list2[i].head.data){
                    return false;
                }
                list1[i].head = list1[i].head.next;
                list2[i].head = list2[i].head.next;
            }
        }
        return true;
    }
}


