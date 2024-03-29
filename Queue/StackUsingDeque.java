package Queue;

import java.util.Deque;
import java.util.LinkedList;


public class StackUsingDeque {
    static class stack{
        Deque<Integer> dq = new LinkedList<>();

        void push(int data){
            dq.addLast(data);
        }
        int pop(){
            return dq.removeLast();

        }

        int peek(){
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
        
        stack s = new stack();
        s.push(10);
        s.push(11);
        s.push(12);
        System.out.println(s.peek());
    }
    
}
