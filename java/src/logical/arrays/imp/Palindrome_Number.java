package logical.arrays.imp;

public class Palindrome_Number {

    public static boolean isPalindrome(int num){
        System.out.print("Input => "+num+" :: ");
        if(num < 0)
            return false;
        int original = num;
        int reversed = 0;
        while(num != 0){
            int lastDigit = num % 10;
            reversed = reversed * 10 + lastDigit;
            num = num/10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); //true
        System.out.println(isPalindrome(101)); // true
        System.out.println(isPalindrome(0)); //true
        System.out.println(isPalindrome(123)); //false
        System.out.println(isPalindrome(-121)); //false

    }
}
