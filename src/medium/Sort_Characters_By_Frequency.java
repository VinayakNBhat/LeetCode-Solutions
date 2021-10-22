package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String str = "tree";
        StringBuilder sc = new StringBuilder();

        Map<String, Long> map = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map.values());

        for (Map.Entry<String, Long> entry : map.entrySet()) {

        }
    }
}
