package com.kiranmarturu.codedojo;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] tc1 = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int[] tc2 = new int[] { 4, 2, 0, 3, 2, 5 };

    Util.printResult(tc1, 6, solution.trap(tc1));
    Util.printResult(tc2, 9, solution.trap(tc2));
  }
}

class Solution {

  public int trap(int[] height) {
    //return bruteForce(height);
    //return memoization(height);
    return twoPointer(height);
  }

  /**
   * Intuition:
   * For a given index the amount of water it contains depends on
   * left max height, right max height and it's own height
   * MIN(left max height, right max height) - own height
   */

  /**
   * Approach 1: Brute Force - Calculate leftMax and rightMax for each index
   * and calculate capacity add to result
   *
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   */
  public int bruteForce(int[] height) {
    int n = height.length;
    int result = 0;

    for (int i = 1; i < n - 1; i++) {
      int leftMax = 0;
      int rightMax = 0;

      for (int j = i; j >= 0; j--) {
        leftMax = Math.max(height[j], leftMax);
      }

      for (int j = i; j < n; j++) {
        rightMax = Math.max(height[j], rightMax);
      }

      // if height[i] itself is the highet then
      // leftMax == rightMax == height[i]

      result += Math.min(leftMax, rightMax) - height[i];
    }

    return result;
  }

  /**
   * Approach 2: Memoization - Calculate left max and right max for all indices
   * and loop throught to calculate result from the stored result.
   *
   * Time Complexity: O(n) actually 3n
   * Space Complexity: O(n) actually 2n
   */
  public int memoization(int[] heights) {
    int n = heights.length;
    int result = 0;

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = heights[0];
    rightMax[n - 1] = heights[n - 1];

    // exclude left-most
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(heights[i], leftMax[i - 1]);
    }

    // exclude right-most
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
    }

    for (int i = 1; i < n - 1; i++) {
      result += Math.min(leftMax[i], rightMax[i]) - heights[i];
    }

    return result;
  }

  /**
   * Approach 3: Use two pointers - Using the observation that holding capacity
   * depends on the min value not on the max.
   * leftMax always represent max of [start...left]
   * rightMax always represent max of [right...end]
   *
   * Time Complexity: O(n)
   * Space Complecity: O(1)
   */
  public int twoPointer(int[] height) {
    int n = height.length;
    int result = 0;

    int left = 0;
    int right = n - 1;

    int leftMax = height[0];
    int rightMax = height[n - 1];

    while (left <= right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);

      if (leftMax < rightMax) {
        result += leftMax - height[left];
        left++;
      } else {
        result += rightMax - height[right];
        right--;
      }
    }

    return result;
  }
}
