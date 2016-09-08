import java.util.Arrays;

public class Stacks {

	//stack is essentially an array.
	private String[] stack;
	private int stackSize;
	
	//indication for stack is empty
	private int topOfStack=-1;
	
	/**
	 * Parameterized constructor.
	 * @param size
	 */
	Stacks(int size){
		stackSize= size;
		stack= new String[size];
		//fill the array(stack) with anything but -1
		Arrays.fill(stack, "-1");
	}
	
	/**
	 * default constructor
	 */
	public Stacks() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Pushing item on to the stack.
	 * @param item : string to be pushed on the stack
	 */
	public void push(String item){
		if(topOfStack+1<stackSize){
			System.out.println("ADDING TO THE STACK!");
			topOfStack++;
			stack[topOfStack]=item;
		}
		else
			System.out.println("STACK IS FULL");
		
		printStack();
		System.out.println("Item :"+item+" was added to the stack!!");

	}
	
	/**
	 * popping an element.
	 * @return
	 */
	public String pop(){
		if(topOfStack>=0){
			 
			System.out.println("POPPING VALUE: "+stack[topOfStack]);
			//assign the stack top value to -1. it won't appear as per out declaration.
			stack[topOfStack]= "-1";
			stackSize--;
			System.out.println("Stack was popped!");
			printStack();
			return stack[topOfStack--];
			
		
		}
		else {
			
			System.out.println("STACK IS EMPTY!!");
			return "-1";
		}
	}
	
	/**
	 * gives the top most value of the array.
	 */
	public void peek(){
		System.out.println("PEEKING.....");
		if(topOfStack == -1)
			System.out.println("Stack is empty!! ");
		else
		System.out.println("Value is : "+ stack[topOfStack]);
	}
	
	/**
	 * push multiple strings separated by space
	 * @param multipleStrings
	 */
	public void pushMultipleValues(String multipleStrings){
		String[] tempArray=multipleStrings.split(" ");
		for(int i=0;i<tempArray.length;i++)
			push(tempArray[i]);
	}
	
	public void popAll(){
		System.out.println("POPPING ALL THE VALUES !!");
		for(int i=topOfStack;i>=0;i--)
				pop();
		}
	/**
	 * printing the stack
	 */
	public void printStack(){
		System.out.println("!!!!!!!!!!!!!  Printing stack  !!!!!!!!!!!!!");
		for(int j=0;j<stackSize;j++){
			if(stack[j].equals("-1"))
				System.out.println("Index : "+j+"  Value : ");
			else
			System.out.println("Index : "+j+"  Value : "+stack[j]);
		}
		System.out.println("STACK SIZE :" +stackSize);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stacks stackStructure= new Stacks(10);
		stackStructure.push("HELLO1");
		stackStructure.push("HELLO2");
		stackStructure.push("HELLO3");
		stackStructure.push("HELLO4");
		stackStructure.push("HELLO5");
		stackStructure.push("HELLO6");
		stackStructure.pop();
		stackStructure.push("HELLO7");
		//stackStructure.peek();
		stackStructure.pushMultipleValues("HI WHATSUP");
		stackStructure.popAll();
		stackStructure.printStack();
		stackStructure.peek();
		
	}

}
