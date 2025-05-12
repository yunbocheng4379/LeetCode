package com.example.leetcode.hot.doublepoint;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-03 12:43
 */
/*
* 1. 左指针左边均不为零。
* 2. 右指针左边直到左指针处均为零。
* */
public class 移动零_283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                //当right对应的元素不等于0的时候，需要交换left和right所对应的元素
                swap(nums, left, right);
                //交换之后需要移动左指针
                left++;
            }
            //每循环一次都需要移动右指针
            right++;
        }
    }

    public static void swap(int num[], int left, int right) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }
}
