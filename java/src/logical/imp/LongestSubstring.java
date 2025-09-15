package logical.imp;

import java.util.*;

//Input: s = "abcabcbb" Output: 3
//Input: s = "bbbbb" Output: 1
//Input: s = "pwwkew" Output: 3
//link - https://www.youtube.com/watch?v=VvS_CtSIeiQ
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String str){
        System.out.print("Input => "+str+", Output => ");
        int maxLength = 0;
        int left = 0;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int right = 0; right<str.length(); right++){
            char c = str.charAt(right);
            if(map.containsKey(c)){
                left = map.get(c)+1;
            }
            map.put(c,right);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabdcbb")); //4
        System.out.println(lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("")); //0
        System.out.println(lengthOfLongestSubstring("a")); //1
        System.out.println(lengthOfLongestSubstring("ab")); //2
        System.out.println(lengthOfLongestSubstring("aa")); //1
        System.out.println(lengthOfLongestSubstring("")); //0
        System.out.println(lengthOfLongestSubstring("abcdef")); //6
        System.out.println(lengthOfLongestSubstring("abcdea")); //5
        System.out.println(lengthOfLongestSubstring("abcaef")); //5
        System.out.println(lengthOfLongestSubstring("abc def")); //7
        System.out.println(lengthOfLongestSubstring("aa")); //1
    }
}
