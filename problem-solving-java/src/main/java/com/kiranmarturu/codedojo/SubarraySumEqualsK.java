package com.kiranmarturu.codedojo;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] tc1 = new int[] { 1, 1, 1 };
    int[] tc2 = new int[] { 1, 2, 3 };

    Util.printResult(tc1, 2, solution.subarraySum(tc1, 2));
    Util.printResult(tc2, 2, solution.subarraySum(tc2, 3));
  }
}

class Solution {

  public int subarraySum(int[] nums, int k) {
    return bruteForce(nums, k);
  }

  private int bruteForce(int[] nums, int k) {
    int matchCount = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int sum = 0;
        // sum elements from i to j
        for (int x = i; x <= j; x++) {
          sum = sum + nums[x];
        }

        if (sum == k) {
          matchCount++;
        }
      }
    }

    return matchCount;
  }
}
