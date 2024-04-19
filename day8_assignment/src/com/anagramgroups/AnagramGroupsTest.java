package com.anagramgroups;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class AnagramGroupsTest {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    @Test
    public void testGroupAnagrams() {
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected1 = Arrays.asList(
                Arrays.asList("eat", "tea", "ate"),
                Arrays.asList("tan", "nat"),
                Arrays.asList("bat")
        );
        sortListOfLists(expected1);
        List<List<String>> actual1 = groupAnagrams(input1);
        sortListOfLists(actual1);
        assertEquals(expected1, actual1);

        String[] input2 = {"hello", "world", "cat", "act", "dog"};
        List<List<String>> expected2 = Arrays.asList(
                Arrays.asList("hello"),
                Arrays.asList("world"),
                Arrays.asList("cat", "act"),
                Arrays.asList("dog")
        );
        sortListOfLists(expected2);
        List<List<String>> actual2 = groupAnagrams(input2);
        sortListOfLists(actual2);
        assertEquals(expected2, actual2);

        String[] input3 = {"listen", "silent", "dear", "read", "earth", "heart"};
        List<List<String>> expected3 = Arrays.asList(
                Arrays.asList("listen", "silent"),
                Arrays.asList("dear", "read"),
                Arrays.asList("earth", "heart")
        );
        sortListOfLists(expected3);
        List<List<String>> actual3 = groupAnagrams(input3);
        sortListOfLists(actual3);
        assertEquals(expected3, actual3);

        String[] input4 = {"apple", "banana", "orange"};
        List<List<String>> expected4 = Arrays.asList(
                Arrays.asList("apple"),
                Arrays.asList("banana"),
                Arrays.asList("orange")
        );
        sortListOfLists(expected4);
        List<List<String>> actual4 = groupAnagrams(input4);
        sortListOfLists(actual4);
        assertEquals(expected4, actual4);

        String[] input5 = {};
        List<List<String>> expected5 = new ArrayList<>();
        sortListOfLists(expected5);
        List<List<String>> actual5 = groupAnagrams(input5);
        sortListOfLists(actual5);
        assertEquals(expected5, actual5);

        String[] input6 = {"Aa", "aA", "BB", "bb"};
        List<List<String>> expected6 = Arrays.asList(
                Arrays.asList("Aa", "aA"),
                Arrays.asList("BB", "bb")
        );
        sortListOfLists(expected6);
        List<List<String>> actual6 = groupAnagrams(input6);
        sortListOfLists(actual6);
        assertEquals(expected6, actual6);
    }

    private void sortListOfLists(List<List<String>> lists) {
        lists.sort(Comparator.comparing(list -> list.toString()));
        for (List<String> list : lists) {
            Collections.sort(list);
        }
    }
}

