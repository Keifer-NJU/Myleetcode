package leetcode;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。   第一次题意都不知道  惭愧
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标（表示第几个栈），value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 */
public class TripleInOneDemo {
    int[] valueArray;
    int size;
    public TripleInOneDemo(int stackSize) {
        valueArray = new int[stackSize*3+3];
        size = stackSize;
    }

    public void push(int stackNum, int value) {
        int stackPos = valueArray[size*3+stackNum];
        if(stackPos<size){
            valueArray[stackNum*size+stackPos]=value;
            valueArray[size*3+stackNum] += 1;
        }
    }

    public int pop(int stackNum) {
        int stackPos = valueArray[size*3+stackNum];
        if(stackPos>0){
            valueArray[size*3+stackNum] -= 1;
            int retureValue = valueArray[stackNum*size+stackPos-1];
            return retureValue;
        }
        else return -1;
    }

    public int peek(int stackNum) {
        int stackPos = valueArray[size*3+stackNum];
        if(stackPos>0){
            int retureValue = valueArray[stackNum*size+stackPos-1];
            return retureValue;
        }
        else return -1;
    }

    public boolean isEmpty(int stackNum) {
        int stackPos = valueArray[size*3+stackNum];
        return stackPos==0;
    }
}
