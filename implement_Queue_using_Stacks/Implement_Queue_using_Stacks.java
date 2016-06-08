package implement_Queue_using_Stacks;

import java.util.Stack;

// The highest voted answer on leetcode is smarter and much more efficient. --- use two stacks
// one records the right order and the other records the reversed order.
// See "Editorial Solution"
public class Implement_Queue_using_Stacks {

	private Stack<Integer> q;
	
	public Implement_Queue_using_Stacks() {
		q = new Stack<>();
	}
	// Push element x to the back of queue.
    public void push(int x) {
    	Stack<Integer> p = new Stack<>();
        while (!q.isEmpty()) {
			p.push(q.pop());
		}
        q.push(x);
        while (!p.isEmpty()) {
			q.push(p.pop());
		}
    }

    // Removes the element from in front of queue.
    public void pop() {
        q.pop();
    }

    // Get the front element.
    public int peek() {
        return q.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return q.isEmpty();
    }
    
}
