package pij.day14.list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleLinkedListTest {

    private static List<Integer> make123List() {
        return List.of(1, 2, 3);
    }

    private static SimpleList<Integer> make123SimpleList() {
        // automatic upcast
        return make123SimpleLinkedList();
    }

    private static SimpleLinkedList<Integer> make123SimpleLinkedList() {
        SimpleLinkedList<Integer> simpleList = new SimpleLinkedList<>();
        simpleList.add(0, 1);
        simpleList.add(1, 2);
        simpleList.add(2, 3);
        return simpleList;
    }

    @Test
    void testConstructor_List_zeroElements() {
        List<Integer> input = List.of();
        SimpleList<Integer> simpleList = new SimpleLinkedList<>(input);
        List<Integer> actual = simpleList.toList();
        List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_List_threeElements() {
        List<Integer> input = make123List();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedList<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = make123List();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleList_zeroElements() {
        SimpleList<Integer> input = new SimpleLinkedList<>();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedList<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleList_threeElements() {
        SimpleList<Integer> input = make123SimpleList();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedList<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = make123List();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleLinkedList_zeroElements() {
        SimpleLinkedList<Integer> input = new SimpleLinkedList<>();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedList<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor_SimpleLinkedList_threeElements() {
        SimpleLinkedList<Integer> input = make123SimpleLinkedList();
        SimpleList<Integer> actualSimpleList = new SimpleLinkedList<>(input);
        List<Integer> actual = actualSimpleList.toList();
        List<Integer> expected = make123List();
        assertEquals(expected, actual);
    }

}