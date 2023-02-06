package com.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * Solution using: char freq. int array.
 * TC:O(N): Where N is he length of the String.
 * SC:O(N)
 * <p>
 * Here we have to return index of the first unique character.
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        int index = -1;
        String s = "leetcode";
        int result = findUniqueCharacter(s);
        System.out.println(result >= 0 ? result : index);
        s = "loveleetcode";
        result = findUniqueCharacter(s);
        System.out.println(result >= 0 ? result : index);
        s = "aabb";
        result = findUniqueCharacter(s);
        System.out.println(result >= 0 ? result : index);
        //Edge case
        s = "aaaaaaaaaaaaaaaaaaaaaaab";
        result = findUniqueCharacter(s);
        System.out.println(result >= 0 ? result : index);
    }

    private static int findUniqueCharacter(String s) {
        if (s.isBlank()) {
            return -1;
        }

        int[] charFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charFreq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
