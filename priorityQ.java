/**
 * 
 */

/**
 * @author Khyati K.Vyas
 *
 */
public class priorityQ {

	private String[] Q;
	private int front, back, items = 0;
	private int size;

	/**
	 * Parameterized constructor
	 */
	public priorityQ(int n) {
		// TODO Auto-generated constructor stub
		size = n;
		Q = new String[n];

	}

	/**
	 * Inserting a value into the queue in descending order
	 * 
	 * @param input:
	 *            value to be inserted
	 */
	public void insert(String input) {
		int i;
		System.out.println("INSERTING :" +input);
		if (items == 0) {
			Q[back] = input;
			back++;
			items++;
		} else {
			for (i = items - 1; i >= 0; i--) {
				if (Integer.parseInt(input) > Integer.parseInt(Q[i]))
					Q[i + 1] = Q[i];
				else
					break;

			}
			Q[i + 1] = input;
			back++;
			items++;
		}
	}

	/**
	 * Deleting element from the start of the queue.
	 */
	public void delete() {
		if (items > 0) {
			System.out.println("REMOVING 1st ELEMENT FROM QUEUE.");

			for (int i = 0; i < size - 1; i++) {
				Q[i] = Q[i + 1];
				back--;
			}
			items--;
			System.out.println("Now item " + Q[front] + " is at the front");
			// System.out.println("Now item "+qArray[back]+" is at the back");
		} else {
			System.out.println("Queue is empty!!");
		}
	}

	/**
	 * Peeking the top value.
	 */
	public void peek() {
		System.out.println("!!!!!!!!!!!! PEEKING !!!!!!!!!!!!!");
		System.out.println(" Value is :" + Q[front]);
	}

	/**
	 * Printing the priority queue.
	 */
	public void display() {
		System.out.println("!!!!!!!!!!!!!!!!! PRINTING !!!!!!!!!!!!!!!!!");
		for (int i = 0; i < items; i++) {
			System.out.println("INDEX : " + i + "VALUE : " + Q[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		priorityQ QObject = new priorityQ(10);
		QObject.insert("10");
		QObject.insert("8");
		QObject.insert("11");
		QObject.insert("1");
		QObject.display();
		QObject.delete();
		QObject.display();
		QObject.insert("5");
		QObject.display();
		QObject.delete();
	}

}
