import java.util.Arrays;

public class ArrayQueue implements Queue {

	private Object[] queue;
	private int size;
	private int front = 0;
	private int rear = 0;
	
	public ArrayQueue() {
		queue = new Object[10];
	}
	
	@Override
	public Object dequeue() {
		var element = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		size--;
		return element;
	}

	@Override
	public void enqueue(Object item) {
		
		if(queue[rear] != null) {
			int top = queue.length;
			resize(2);
			for(int i = 0; i < rear; i++) {
				queue[top] = queue[i];
				queue[i] = null;
				top++;
			}
			rear = top++;
		}
		queue[rear] = item;
		rear = (rear + 1)% queue.length;
		
		size++;
	}
	
	public int size() {
		return size;
	}
	
	private void resize(int x) {
		var temp = new Object[queue.length * x];
		for(int i = 0; i < queue.length; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(queue);
	}

}
