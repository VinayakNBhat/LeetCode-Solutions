package easy;

/**
 * https://leetcode.com/problems/ransom-note/
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 */
public class Ransom_Note {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int ransomNoteSize = ransomNote.length();
            int magazineSize = magazine.length();

            if (magazineSize < ransomNoteSize) {
                return false;
            }

            int[] ransomNoteMap = new int[26];
            int[] magazineMap = new int[26];
            int max = Math.max(ransomNoteSize, magazineSize);
            for(int i = 0; i < max; i++) {
                if (i < ransomNoteSize) {
                    ransomNoteMap[ransomNote.charAt(i) - 'a']++;
                }

                if(i < magazineSize) {
                    magazineMap[magazine.charAt(i) - 'a']++;
                }
            }

            for(int i = 0; i < 26; i++) {
                if (magazineMap[i] < ransomNoteMap[i])
                    return false;
            }

            return true;
        }
    }
}
