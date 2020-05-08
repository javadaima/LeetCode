package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     */
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<char[]> charsList = new ArrayList<>();
        char[] chars1 = null;
        for (int i = 0; i < s.length(); i++) {
            int i1 = (i+1) % ((numRows- 1) * 2 );
            if(i1 == 1 || i1 > numRows || i1 == 0){
                chars1 = new char[numRows];
            }
            if(i1 <= numRows && i1>0){
                chars1[i1-1] = s.charAt(i);
            }else{
                if(i1 == 0){
                    chars1[1] = s.charAt(i);
                }else{
                    chars1[2*numRows-i1-1] = s.charAt(i);
                }

            }
            if(i1 >= numRows || i1 == 0 || i == s.length() - 1){
                charsList.add(chars1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for(char[] chars:charsList){
                if(chars[i] != '\u0000'){
                    char aChar = chars[i];
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        int i = 0 % 5;
        String leetcodeishiring = convert("PAYPALISHIRING", 3);
        System.out.println(leetcodeishiring);
    }
}
