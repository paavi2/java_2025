package logical.arrays.imp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// two given string character frequency should be same
public class AnagramCheck {

    public static boolean isAnagramUsingCollection(String str1, String str2){
        System.out.print("Str1 => "+ str1 + ", Str2 => "+str2+" :: ");
        List<Character> list1 = new ArrayList<>();
        for(Character c : str1.toLowerCase().toCharArray()){
            list1.add(c);
        }
        List<Character> list2 = new ArrayList<>();
        for(Character c : str2.toLowerCase().toCharArray()){
            list2.add(c);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    public static boolean isAnagram(String str1, String str2){
        System.out.print("Str1 => "+ str1 + ", Str2 => "+str2+" :: ");
        if( str1.length() != str2.length())
            return false;
//        char ch1[] = str1.toLowerCase().toCharArray();
//        char ch2[] = str2.toLowerCase().toCharArray();
//        Arrays.sort(ch1);
//        Arrays.sort(ch2);
//        return Arrays.equals(ch1,ch2);
        return sortString(str1).equals(sortString(str2));
    }

    private static String sortString(String str){
        String out = "";
        char ch[] = str.toLowerCase().toCharArray();
        for(int i=1; i<ch.length; i++){
            if(ch[i-1] > ch[i]){
              char temp = ch[i-1];
              ch[i-1] = ch[i];
              ch[i] = temp;
            }
        }
        for(char c : ch){
            out +=c;
        }
        return out;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("yes","yes")); //true
//        System.out.println(isAnagramUsingCollection("listen","silent")); //true
//        System.out.println(isAnagramUsingCollection("elegant man","a gentleman")); //true
//        System.out.println(isAnagramUsingCollection("rail safety","fairy tales"));
//        System.out.println(isAnagramUsingCollection("121","321")); //true
//        System.out.println(isAnagramUsingCollection("Debit Card","Bad Credit")); //true
//        System.out.println(isAnagramUsingCollection("Eleven plus two","Twelve plus one")); //true
//        System.out.println(isAnagramUsingCollection("rat","car")); //false
//        System.out.println(isAnagramUsingCollection("","")); //true
//        System.out.println(isAnagramUsingCollection("a","a")); //true
    }
}
