import java.util.LinkedList;


	public class Stack<T> {

		private LinkedList<T> storage = new LinkedList<T>();

		public void push(T v) {
			storage.addFirst(v);
		}

		public T pop() {
			return storage.removeFirst();
		}

		public T peek() {
			return storage.getFirst();
		}

		public boolean empty() {
			return storage.isEmpty();
		}

		public String toString() {
			return storage.toString();
		}
	}