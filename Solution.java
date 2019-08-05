import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution {
    private HashMap<Character, Character> mappings;
    public  Solution(){
        mappings = new HashMap<>();
        mappings.put('}', '{');
        mappings.put(')', '(');
        mappings.put(']','[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = stack.isEmpty()? '#': stack.pop();
                if (mappings.get(c) !=  topElement) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return  stack.isEmpty();
    }
}
