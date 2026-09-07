import java.util.*;
class Solution {
    public boolean isValid(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<>(); 
        
        for (char a : arr) {
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            } 
            else if (a == ')' || a == ']' || a == '}') {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((a == ')' && top != '(') || 
                    (a == ']' && top != '[') || 
                    (a == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
