import java.util.Arrays;

public class ArrayStack implements Stack {
	
	private Object[] stack;
	private int top = 0;
	
	public ArrayStack() {
		this.stack = new Object[10];
	}

	@Override
	public void push(Object item) {
		if(top == stack.length) {
			resize(2);
		}
		
		this.stack[top] = item;
		top++;
	}
	
	private void resize(int x) {
		var temp = new Object[stack.length * x];
		for(int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}

	@Override
	public Object pop() {
		var element = stack[--top];
		stack[top] = null;
		return element;
	}

	@Override
	public Object peek() {
		return stack[top];
	}

	@Override
	public boolean empty() {
		return stack[0] == null;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(stack);
	}

}
