package com.example.leetcode.hot.doublepoint;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-03 17:33
 */
/*
* 双指针
* */
public class 接雨水_42 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0};
        int trap = trap(height);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        //定义左右指针的起始位置
        int left = 0;
        int right = height.length - 1;
        //左指针左边的最大高度，右指针右侧的最大高度(注意：左边和右边关键字)
        int leftMax = height[left];
        int rightMax = height[right];
        //最两边的列无法存储水(相当于只存在两个柱子，并且这两个柱子是挨着的，不能存储，至少得存在三个)
        left++;
        right--;
        /*
        指针向中间靠拢，继续计算其他值，这个地方需要加上等于(比如：只存在三个柱子时，如果不等于的话，经历上述运算之后就超出范围了
        万一是 1,0,1 不等的话不会进入计算体，直接结束，结果是不对的)
        * */
        while (left <= right) {
            //计算左指针左边的最大值
            leftMax = Math.max(leftMax, height[left]);
            //计算右指针右边的最大值
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                /*
                * 左指针的leftMax比右指针的rightMax矮
                * 说明：左指针的右边至少有一个板子 > 左指针左边所有板子
                * 根据水桶效应，保证了左指针当前列的水量决定权在左边
                * 那么可以计算左指针当前列的水量：左边最大高度-当前列高度
                * */
                res += leftMax - height[left];
                left++;
            }else {
                //右边同理
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

}
