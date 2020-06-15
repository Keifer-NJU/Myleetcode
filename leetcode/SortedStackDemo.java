package leetcode;

import java.util.Stack;

/**
 *
 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈（stack2）存放数据，但不得将元素复制到别的数据结构（如数组）中。
 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

 优化：3、还有没有继续优化的可能？有！连续多次push时，需要多次把元素在两个栈中传递。想象这样一个极端情况：
 连续n次push相同或相近元素，需要来回操作2n x i次，其中i为每次移动的元素数量。
 实际上，我们只需要移动2 x i次：先把i个元素移到辅助栈，再把n个元素放入栈，最后将辅助栈中元素移回来即可。
 此为惰性更新
 惰性更新策略运用很广泛，比如著名的U&F算法、区间树等，就使用了此策略。
 */
public class SortedStackDemo {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public SortedStackDemo() {
        stack1 = new Stack<>();
        stack2 =new Stack<>();
    }

    public void push(int val) {
        int max = stack1.isEmpty()?Integer.MAX_VALUE: stack1.peek();
        int min = stack2.isEmpty()?Integer.MIN_VALUE: stack2.peek();
        if(val<=max&&val>=min){
            stack1.push(val);
            max = val;
        }
        else if(val>max){
            while (!stack1.isEmpty()&&max<val){
                stack2.push(stack1.pop());
                max = stack1.peek();
            }
            stack1.push(val);
        }
        else {
            while (!stack2.isEmpty()&&min>val){
                stack1.push(stack2.pop());
                min = stack2.peek();
            }
            stack1.push(val);
        }
//        if(val>peek()&&(!stack1.isEmpty())){
//            while ((!stack1.isEmpty())&&stack1.peek()<val){
//                stack2.push(stack1.pop());
//            }
//            stack1.push(val);
//            while (!stack2.isEmpty()){
//                stack1.push(stack2.pop());
//            }
//        }
//        else {
//            stack1.push(val);
//        }
    }

    public void pop() {
        peek();
        stack1.pop();
    }

    public int peek() {
        if(!isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return stack1.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
