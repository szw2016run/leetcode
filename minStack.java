import java.util.Stack;
/**
 *设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中
 * pop() -- 删除栈顶的元素
 * top() -- 获取栈顶元素
 * getMin() -- 检索栈中的最小元素
 */
//看到题目第一想法是设置一个变量记录最小值，但是实现起来发现一旦栈结构发生改变要重新找最小值，不大好写然后看了解析利用辅助栈然后自己实现了一下

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
