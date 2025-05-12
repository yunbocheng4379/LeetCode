package com.example.leetcode.hot.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-03 15:43
 */

/*
* 排序 + 双指针
* */
public class 三数之和_15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }
        //排序
        Arrays.sort(nums);
        //存储结果集
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //双指针，找到 num[l] + num[r] = -num[i]
            //因为满足条件的三个数字的下标不能相同，所以左下标要从下一个开始
            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];

            // l!=r，也是为了满足三个数字下标不一样的条件
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    //满足条件，存储数据
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    //跳过重复的元素，因为结果中只保留的数据，而不是下标
                    //只是跳过重复的，可能其中还存在不重复的数据，接着走以上的循环进行判断
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }else if (sum < target) {
                    //因为数据排序过，比目标值小需要向值大的方向移动，左指针向右移动
                    l++;
                }else {
                    //比目标值大需要向值小的方向移动，右指针向左移动
                    r--;
                }
            }
        }
        return res;
    }

}
