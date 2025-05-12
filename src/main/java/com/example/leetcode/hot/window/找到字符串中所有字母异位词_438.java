package com.example.leetcode.hot.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2025-01-04 13:54
 */

public class 找到字符串中所有字母异位词_438{

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        String target = sortStr(p);
        int targetLen = p.length();
        for (int i = 0; i<s.length();i++) {
            String str = "";
            if (i == s.length() - targetLen) {
                str = sortStr(s.substring(s.length() - targetLen));
                if (Objects.equals(str, target)) {
                    res.add(i);
                }
                break;
            }else {
                //每次都按照顺序获取p长度个字符，然后进行排序，对排序后的p进行比较，相等则保存其中的开始下标值
                str = sortStr(s.substring(i, i + targetLen));
                if (Objects.equals(str, target)) {
                    res.add(i);
                }
            }

        }
        return res;
    }

    public static String sortStr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
