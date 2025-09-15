package logical.arrays.imp;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValidParanthesis(String str){
        System.out.print("Input => "+str+" :: ");
        Stack<Character> st = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else if(ch == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            } else if(ch == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            } else if(ch == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParanthesis("{[]}")); //true
        System.out.println(isValidParanthesis("()[]{}")); //true
        System.out.println(isValidParanthesis("([)]")); //false - order is different
        System.out.println(isValidParanthesis("(({{))]]")); //false
    }
}
