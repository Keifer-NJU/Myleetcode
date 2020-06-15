package leetcode;

import java.util.Stack;

/**
 * 面试题 03.04. 化栈为队
 * 原先：每次push都将数据翻转，即两个链表互换
 * 优化：一个栈保存push   一个栈保存pop  等pop栈为空，将push再给pop栈
 */
public class MyQueueDemo {
    /** Initialize your data structure here. */
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;
    public MyQueueDemo() {
        stackPush = new Stack<>();
        stackPop  = new Stack<>();
    }

    /** Push element x to the back of queue. */
//    public void push(int x) {
//        while (!stackPop.isEmpty()){
//            stackPush.push(stackPop.pop());
//        }
//        stackPush.push(x);
//        while (!stackPush.isEmpty()){
//            stackPop.push(stackPush.pop());
//        }
//    }
    public void push(int x) {
//        while (!stackPop.isEmpty()){
//            stackPush.push(stackPop.pop());
//        }
        stackPush.push(x);
//        while (!stackPush.isEmpty()){
//            stackPop.push(stackPush.pop());
//        }
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp = peek();
        stackPop.pop();
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        if(!stackPop.isEmpty()) return stackPop.peek();
        else{
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPop.isEmpty()&&stackPush.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */