package leetcode;

import org.junit.Test;

public class Demo5 {
    /** 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

     示例 1：
     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。
     */
    public String longestPalindrome(String s) {

        String result = "";
        for (int i = 0; i <s.length(); i++) {
            String str;
            int n = 0;
            int left = 0;
            int right = 0;
            //注意数组不可越界
            //1.找出附近的重复元素
            if(i>0) {
                while((i-left)>0){
                    left++;
                    if(s.charAt(i) != s.charAt(i-left)){
                        left--;
                        break;
                    }
                }
            }
            if(i<s.length()-1) {
                while(i+right<s.length()-1){
                    right++;
                    if( s.charAt(i) != s.charAt(i+right)){
                        right--;
                        break;
                    }
                }
            }
            //2.找出两侧的对称元素
            if(i-left>0 && i+right<s.length()-1){
                while ((i-left)> 0 && (right+i)< s.length()-1){
                    left++;
                    right++;
                    if(s.charAt(i-left) != s.charAt(i+right)){
                        left--;
                        right--;
                        break;
                    }
                }
            }

            str = s.substring(i-left,i+right+1);
            if(str.length() > result.length()){
                result  = str;
            }
        }
        return result;
    }

    public String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i <s.length(); i++) {
            String str = s.charAt(i) + "";
            int n = 0;
            int left = 0;
            int right = 0;
            //两条路，一个往左，一个往右
            while(true){
                if(i > 0){
                    left++;
                    if(s.charAt(i) == s.charAt(i+left)){

                    }
                }


            }
        }

        return result;
    }

    @Test
    public void test1() {
        String str = "a";
        String s = longestPalindrome(str);
        System.out.println(s);
    }
}
