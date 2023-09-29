package com.kiranmarturu.codedojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubStringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String tc1 = "abcabcbb";
    String tc2 = "bbbbb";
    String tc3 = "pwwkew";

    Util.printResult(tc1, 3, solution.lengthOfLongestSubstring(tc1));
    Util.printResult(tc2, 1, solution.lengthOfLongestSubstring(tc2));
    Util.printResult(tc3, 3, solution.lengthOfLongestSubstring(tc3));
  }
}

class Solution {

  /**
   * Intuition: Sliding window technique with a Set holding
   * the unique characters
   */
  public int lengthOfLongestSubstring(String s) {
    int max = 0, left = 0, right = 0;
    Set<Character> charsInWindow = new HashSet<>();

    while (right < s.length()) {
      if (charsInWindow.contains(s.charAt(right))) {
        charsInWindow.remove(s.charAt(left));
        left++;
      } else {
        charsInWindow.add(s.charAt(right));
        right++;
        max = Math.max(max, charsInWindow.size());
      }
    }

    return max;
  }
}
