package com.example.leetcode.hot.doublepoint;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-03 14:57
 */

public class 盛水最多的容器_11 {

    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        int i = maxArea(height);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int width = height.length - 1;
        int left = 0;
        int right = width;
        int max = 0;
        while (left != right) {
            max = Math.max(Math.min(height[left], height[right]) * width, max);
            if (height[left] <= height[right]) {
                left++;
            }else {
                right--;
            }
            width--;
        }
        return max;
    }

}
