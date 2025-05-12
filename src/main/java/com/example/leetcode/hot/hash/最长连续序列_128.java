package com.example.leetcode.hot.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-03 10:48
 */

public class 最长连续序列_128 {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //创建一个 HashSet集合，去重元素
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //定义一个存储最大序列长度的数值
        int max = 0;
        for (Integer num: set) {
            if (!set.contains(num - 1)) {
                // 如果不存在当前元素减一的值，说明当前元素可能是一个连续序列的起点
                int curNum = num;
                int cutCount = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    cutCount += 1;
                }
                max = Math.max(max, cutCount);
            }
            //存在则说明这个数肯定不是连续序列的一个起点
        }
        return max;
    }
}
