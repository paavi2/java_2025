package logical.arrays.imp;

public class Palindrom_String {

    public static boolean isPalindrome(String str){
        System.out.print("Input => "+str);
        str = str.replace(",","")
                .replace(" ","")
                .toLowerCase();
        int left = 0;
        int right = str.length()-1;
        while(left < str.length()/2){
            if(str.charAt(left) != str.charAt(right)) // Compare by ignoring case
                return false;
            ++left;
            --right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(" => "+isPalindrome("madam")); //true
        System.out.println(" => "+isPalindrome("Madam")); //true
        System.out.println(" => "+isPalindrome("abba")); // true
        System.out.println(" => "+isPalindrome("")); // true
        System.out.println(" => "+isPalindrome("1")); // true
        System.out.println(" => "+isPalindrome("hello")); // false
        System.out.println(" => "+isPalindrome("12321")); // true
        System.out.println(" => "+isPalindrome("12345")); // false
        System.out.println(" => "+isPalindrome("nurses run")); // true
        System.out.println(" => "+isPalindrome("A man, a plan, a canal, Panama")); // true
    }
}
