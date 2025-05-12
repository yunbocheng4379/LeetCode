package com.example.leetcode.hot.substring;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-10 10:47
 */

public class 和为k的子数组_560 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,0};
        int k = 0;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length  == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp == k) {
                res+=1;
            }else if (tmp < k) {
                for (int j = i+1 ; j < nums.length; j++) {
                    tmp+=nums[j];
                    if (tmp > k) {
                        break;
                    }else if (tmp == k) {
                        res+=1;
                        break;
                    }
                }
            }
        }
        return res;
    }

}
