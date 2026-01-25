package pij.day14solutions.listRec;

import org.junit.jupiter.api.Test;
import pij.day14.list.SimpleList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// same class as pij.day14.list.SimpleLinkedListRecTest, except that it tests
// the SimpleLinkedList from the solution
class SimpleLinkedListRecTest {

    private static List<Integer> make123List() {
        return List.of(1, 2, 3);
    }

    private static SimpleList<Integer> make123SimpleListRec() {
        // automatic upcast
        return make123SimpleLinkedListRec();
    }

    private static SimpleLinkedListRec<Integer> make123SimpleLinkedListRec() {
        SimpleLinkedListRec<Integer> simpleList = new SimpleLinkedListRec<>();
        simpleList.add(0, 1);
        simpleList.add(1, 2);
        simpleList.add(2, 3);
        return simpleList;
    }

    @Test
    void testConstructor_List_zeroElements() {
        List<Integer> input = List.of();
        SimpleList<Integer> simpleList = new SimpleLinkedListRec<>(input);
        List<Integer> actual = simpleList.toList();
        List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_List_threeElements() {
        List<Integer> input = make123List();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedListRec<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = make123List();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_List_null() {
        assertThrows(NullPointerException.class,
                () ->  {
                    List<Integer> l = null;
                    SimpleList<Integer> simpleList = new SimpleLinkedListRec<>(l); });
    }

    @Test
    void testConstructor_SimpleList_zeroElements() {
        SimpleList<Integer> input = new SimpleLinkedListRec<>();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedListRec<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleList_threeElements() {
        SimpleList<Integer> input = make123SimpleListRec();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedListRec<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = make123List();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleLinkedListRec_zeroElements() {
        SimpleLinkedListRec<Integer> input = new SimpleLinkedListRec<>();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedListRec<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleLinkedListRec_threeElements() {
        SimpleLinkedListRec<Integer> input = make123SimpleLinkedListRec();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedListRec<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = make123List();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleList_null() {
        assertThrows(NullPointerException.class,
                () ->  {
                    SimpleList<Integer> l = null;
                    SimpleList<Integer> simpleList = new SimpleLinkedListRec<>(l); });
    }
}