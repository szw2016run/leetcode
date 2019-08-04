import java.util.Stack;
public class minStack {
    private Stack<Integer> minStack;
    private  Stack<Integer> helper;
    public minStack() {
        minStack = new Stack<>();
        helper = new Stack<>();
    }

    public  void push(int x) {
        minStack.push(x);
        if (helper.isEmpty() || x < helper.peek()) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (!minStack.isEmpty()) {
            helper.pop();
            minStack.pop();
        }
    }

    public  int getMin() {
        if (!helper.isEmpty()) {
            return  helper.peek();
        }
        throw new RuntimeException("栈中元素为空,操作非法");
    }

    public int top() {
        if (!minStack.isEmpty()) {
            return  minStack.peek();
        }
        throw  new RuntimeException("栈中元素为空，操作非法");
    }

    public static void main(String[] args) {
        minStack min = new minStack();
        min.push(2);
        min.push(6);
        min.push(1);

        System.out.println(min.getMin());
    }
}
