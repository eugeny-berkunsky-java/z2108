package ua.mk.berkut.te;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testReadAll() {
        String filename = "text.txt";
        int expectedSize = 14;
        List<String> list = main.readAll(filename);
        int size = list.size();
        assertEquals(expectedSize, size);
    }

    @Test
    void testMaxLength() {
        List<String> list = main.readAll("text.txt");
        int expected = 53;
        int max = main.maxLength(list);
        assertEquals(expected, max);
    }

    @Test
    void testMaxLengthWithNullLengthList() {
        List<String> list = new ArrayList<>();
        int expected = -1;
        int max = main.maxLength(list);
        assertEquals(expected, max);
    }

    @Test
    void testConcatLines() {
        List<String> list = main.readAll("text.txt");
        String expected = "But as the riper should by time decease,\n" +
                "His tender heir might bear his memory:\n" +
                "But thou contracted to thine own bright eyes,";
        String result = main.concatLines(2,3, list);
        assertEquals(expected, result);
    }

    @Test
    void testConcatLines2() {
        List<String> list = main.readAll("text.txt");
        String expected = "   Pity the world, or else this glutton be,\n" +
                "   To eat the world's due, by the grave and thee.";
        String result = main.concatLines(12,2, list);
        assertEquals(expected, result);
    }

    @Test
    void testCountWordsByLength() {
        String bigLine = main.concatLines(0,14, main.readAll("text.txt"));
        int expectedFor7 = 6;
        int expectedFor8 = 2;
        int resFor7 = main.countWordsByLength(bigLine, 7);
        int resFor8 = main.countWordsByLength(bigLine, 8);
        assertEquals(expectedFor7, resFor7);
        assertEquals(expectedFor8, resFor8);
    }
}