/**
 * 
 */

/**
 * @author Khyati
 *
 */
public class Queues {

	private int qSize;
	private int front, back, noOfItems =0;
	private String[] qArray;
	
	/**
	 * parameterized constructor
	 */
	public Queues(int size) {
		// TODO Auto-generated constructor stub
		qSize=size;
		qArray=new String[qSize];
	}
	
	/**
	 * Inserts item into the queue.
	 * @param input: item to be inserted
	 */

	public void insert(String input){
		if(noOfItems+1<qSize){
			System.out.println("INSERTING ITEM :" +input);
			qArray[back]=input;
			noOfItems++;
			back++;
			
		}else{
			System.out.println("Queue is full!! ");
		}
	}
	
	/**
	 * Deleting element from the start of the queue. My method
	 */
	public void deleteMyMethod(){
		if(noOfItems > 0){
			System.out.println("REMOVING 1st ELEMENT FROM QUEUE.");
			
			for(int i=0;i<qSize-1;i++)
			{qArray[i]=qArray[i+1];
			back--;
			}
			noOfItems--;
			System.out.println("Now item "+qArray[front]+" is at the front");
			//System.out.println("Now item "+qArray[back]+" is at the back");
		}else{
			System.out.println("Queue is empty!!");
		}
	}
	
	/**
	 * Delete method by converting first element to -1 and not displaying it.
	 * My method is perfect. This one will not display just the first element.
	 */
	public void delete(){
		if(noOfItems>0){
			System.out.println(("REMOVING 1st ELEMENT FROM QUEUE."));
			qArray[front]= "-1";
			front++;
			noOfItems--;
		}else{
			System.out.println("Queue is empty!!");
		}
	}
	
	/**
	 * peeking at the first element in the queue.
	 */
	public void peek(){
		System.out.println("PEEKING.................");
		System.out.println("Element on peeking is : "+qArray[front] );
	}
	
	
	/**
	 * Printing the queue.
	 */
	public void displayQ(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!! PRINTING QUEUE !!!!!!!!!!!!!!!!!!!!!");
		for(int i=0;i<noOfItems;i++){
			if(qArray[i]== "-1")
				System.out.println("Index: "+i+" Value: ");
			else
			System.out.println("Index: "+i+" Value: "+qArray[i]);
		}
		System.out.println("Q Size is: "+qSize +" .No of items: "+noOfItems);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queues q= new Queues(10);
		q.insert("10");
		q.insert("30");
		q.insert("20");
		q.insert("40");
		q.insert("60");
		q.insert("50");
		q.displayQ();
		q.deleteMyMethod();
		q.deleteMyMethod();
		//q.delete();
		q.displayQ();
		q.peek();
		
	}

}
