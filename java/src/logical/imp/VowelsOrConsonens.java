package logical.arrays.imp;
/*
* String s = “Loveleen sharmaa haaas interview processes" Write a Java program that processes each word in the string according to the following rules: 1.If a word contains 3 vowels (a, e, i, o, u) that are each repeated 3 times or more, then replace the vowel with 0. 2.If a word contains 3 consonants that are each repeated 3 times or more, then replace the consonants with 1. 3.If a word does not contains 3 consonants or 3 vowels repeated , then replace the
Input -> loveleen Output -> lov0l00n
Input -> sharmaa Output -> sh0rm00

Vowels - 0 Cons -> 1 Min 3
If both conditions not satisfied, replace all word by 1
Input -> interview
Output -> 10*/
public class VowelsOrConsonens {

    public static void checkVowelOrConsonentOrNothing(String sentence){
        sentence = sentence.toLowerCase();
        String words[] = sentence.split(" ");
        boolean isVWith3Count = false;
        boolean isCWith3Count = false;



    }

    public static void main(String[] args) {

    }
}
