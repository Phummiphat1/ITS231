/**
 * A generic queue implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {
	/** The underlying singly linked list for the queue. */
	SList<T> list = new SList<T>();

	/** Default constructor to initialize an empty queue. */
	Queue() {
	}

	/**
	 * Enqueues an element into the queue.
	 *
	 * @param element the element to enqueue
	 */
	void enqueue(T element) {
		// Exercise 1a
		list.addLast(element);
	}

	/**
	 * Dequeues an element from the queue.
	 *
	 * @return the dequeued element
	 */
	T dequeue() {
		// Exercise 1b
		T ret = list.removeFirst();
		return ret; 
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 *
	 * @return the element at the front of the queue
	 */
	T queuefront() {
		T fret = list.removeFirst();
		list.addFirst(fret);
		return fret; // Exercise 1c
	}

	/**
	 * Gets the element at the rear of the queue without removing it.
	 *
	 * @return the element at the rear of the queue
	 */
	T queuerear() {
		T rret = list.removeLast();
		list.addLast(rret);
		return rret; // Exercise 1d
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Creates a copy of this queue.
	 *
	 * @return a new queue containing the same elements as this queue
	 */
	Queue<T> copyQueue() { // Exercise 2
		Queue<T> Q2 = new Queue<T>();
		// Add your code here
		for (int i=1;i<=list.size;i++){
			T temp = dequeue();
			enqueue(temp);
			Q2.enqueue(temp);
		}
		return Q2;
	}

	/**
	 * Checks if this queue is identical to another queue in terms of content and
	 * sequence.
	 *
	 * @param Q2 the queue to compare with
	 * @return true if the queues are identical, false otherwise
	 */
	boolean isIdentical(Queue<T> Q2) {
		//  flag = ture;
		Queue<T> t1 = new Queue<>();
		t1 = this.copyQueue();
		Queue<T> t2 = new Queue<>();
		t2 = Q2.copyQueue();
		if (t2.list.size==t1.list.size)
			for (int i=1;i<=list.size;i++){
				T t2temp = t2.dequeue();
				T t1temp = t1.dequeue();
				if (t2temp!=t1temp){
					return false;
				}
			}
		else{
			return false;
		}
		return true; // Exercise 3
	}

	/**
	 * Prints the elements of the queue horizontally. Handles potential
	 * 
	 */
	void printHorizontal() {
		Node<T> walker = list.first;
		while (walker != null) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}

	}

}