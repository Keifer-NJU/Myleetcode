package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题 03.03. 堆盘子
 * 知识点： List 和 Stack 数据结构， 尤其后者
 */
public class StackOfPlatesDemo {
    List<Stack<Integer>> stackLists = new ArrayList();
    int size;
    public StackOfPlatesDemo(int cap) {
        this.size = cap;
    }

    public void push(int val) {
        if(size<=0)return;
        if(!stackLists.isEmpty()&&stackLists.get(stackLists.size()-1).size()<size){
        //if(stackLists.get(stackLists.size()-1).size()<size&&!stackLists.isEmpty()){
            stackLists.get(stackLists.size()-1).push(val);
        }
        else{
            Stack list = new Stack();
            list.push(val);
            stackLists.add(list);
//            index++;
//            count=1;
        }
    }

    public int pop() {
        if(stackLists.isEmpty())return -1;
        Stack stack = stackLists.get(stackLists.size()-1);
        int result = (int) stack.pop();
        if(stack.isEmpty()){
            stackLists.remove(stackLists.size()-1);
        }
        return result;
    }

    public int popAt(int index) {
        if(index<0||index>stackLists.size()-1)return -1;
        /**
         * 出错
         */
        //if (index==(stackLists.size()-1))pop();
        if (index==(stackLists.size()-1))return pop();
        Stack stack = stackLists.get(index);
        int result = (int) stack.pop();
        if(stack.isEmpty()){
            stackLists.remove(index);
        }
        return result;
    }
}
