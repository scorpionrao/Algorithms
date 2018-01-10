package datastructures.basicdatastructures;

import java.util.*;

public class Brackets {

    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put('{', '}');
                put('(', ')');
                put('[', ']');
            }
        };

        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(') {
                stack.push(map.get(new Character(charArray[i])));
            } else {
                if(stack.isEmpty() || stack.pop().charValue() != charArray[i]) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
