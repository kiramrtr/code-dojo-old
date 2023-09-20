package com.kiranmarturu.codedojo;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

  public static void main(String[] args) {
    Solution solution = new Solution();
    assert solution.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }) == 6;
    assert solution.trap(new int[] { 4, 2, 0, 3, 2, 5 }) == 9;
  }
}

class Solution {

  public int trap(int[] height) {}
}
