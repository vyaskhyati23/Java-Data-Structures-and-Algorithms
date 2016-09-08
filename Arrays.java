public class Arrays{
	
	//array starts with index 0.
	
	 private  int[] array= new int[50]; //array of size 50
	 private  int arraySize= 10; //size of random arrays
	
	/**
	 * random array generator
	 */
	public void randomArrayGenerator(){
		for(int i=0;i<arraySize;i++){
			//(int)(Math.random() * range) + min;
			array[i]=(int) (Math.random()*20)+1;
		}
		
	}
	
	/**
	 * printing array
	 */
	public void printArray(){
		System.out.println("!!!!!!!!!!!!!  Printing array  !!!!!!!!!!!!!");
		for(int j=0;j<arraySize;j++){
			System.out.println("Index : "+j+"  Value : "+array[j]);
		}
		System.out.println("ARRAY SIZE :"+arraySize);
	}
	
	/**
	 *  RETURNS VALUE AT PARTICULAR INDEX
	 * @param index
	 * @return value at index
	 */
	public int valueAtIndex(int index){
		if(index<arraySize)
			return array[index];
		else
			return 12345;
	}
	
	/**
	 * return true or false based on if value was found in the array.
	 * @param value
	 * @return true/false
	 */
	public boolean searchValue(int value){
		boolean valueFound=false;
		
		for(int k=0;k<arraySize;k++){
			if (value==array[k])
				valueFound=true;
		}
	return valueFound;
	}
	
	/**
	 * DELETING A VALUE FROM AN ARRAY AT SPECIFIED INDEX
	 * @param index : index to be deleted
	 */
	public void deleteValueAtIndex(int index){
		
	if(index<arraySize){
		for(int i=index;i<arraySize-1;i++){
		array[i]=array[i+1];
		}
		arraySize--;
	}
	else
		System.out.println("INDEX IS LARGER THAN ARRAY SIZE");
		
	}
	
	/**
	 * INSERTING VALUE AT THE END
	 * @param value: value to be inserted
	 */
	
	public void insertValue(int value){
		if (arraySize<50)
			{
			array[arraySize]=value;
			arraySize++;
			System.out.println("ARRAY SIZE : "+arraySize);}
		else
			System.out.println("ARRAY IS FULL !");
	}
	
	/**
	 * searching entire array for all the indices with searched value
	 * @param value: value to be searched.
	 */
	
	public String linearSearch(int value){
		
		boolean valueInArray= false;
		
		String valueAtIndex=" ";
		System.out.println("VALUE FOUND AT :");
		
		for(int i=0;i<arraySize;i++){
			if(array[i]==value)
			{	
				valueInArray= true;
				valueAtIndex= valueAtIndex+ i+" ";
				
			}
		}
		System.out.println(valueAtIndex);
		
		if(!valueInArray){
			valueAtIndex="NONE";
			System.out.println(valueAtIndex);
		}
		
		return valueAtIndex;
	}
	
	/**
	 * Bubble sort of an arry in ascending order
	 */
	public void bubbleSortAscending(){
		for(int i=arraySize-1;i>1;i--){			//for index. as it decrements all the indexes greater 
												// than it get sorted
			for(int j=0;j<i;j++){				//for value
				if(array[j]>array[j+1])
				swapIndex(j,j+1);
			}
		}
	}
	
	/**
	 * Bubble sort of an array in ascending order
	 */
	public void bubbleSortDescending(){
		for(int i=0;i<arraySize;i++){ 			//for index	
			for(int j=1;j<(arraySize-i);j++){	// for the values
				if(array[j-1]<array[j])			//
				swapIndex(j-1,j);
			}
		}
	}
	
	/**
	 * Binary search implementation
	 * @param value : integer to be found
	 */
	
	public void binarySearchForValue(int value){
		
		int lowIndex=0;
		int highIndex=arraySize-1;
		
		while(lowIndex<=highIndex){
		
		int middleIndex= (lowIndex+highIndex)/2;
		if(value>array[middleIndex])
			lowIndex=middleIndex+1;
		else if(value<array[middleIndex])
			highIndex=middleIndex-1;
		else
		{
			System.out.println("Match found!"+value+" at index :"+ middleIndex);
			lowIndex=highIndex+1;
		}
	}
}
	/**
	 * New sorting implementation.
	 */
	public void someSortIcameUpWith(){
		
		int min=0;
		
		for(int i=0;i<arraySize;i++){
			if(min>array[i])
				{swapIndex(array[i],min);
				min++;
				}
		}
	}
	
	/**
	 * Selection sort implementation.
	 */
	
	public void selectionSort(){
		for(int i=0;i<arraySize;i++)
		{
		int min=i;
		
		for(int j=i;j<arraySize;j++){
			if(array[min]>array[j])
				min=j;
		}
		swapIndex(i,min);
		}
	}
	
	/**
	 * Insertion sort implementation
	 */
	public void insertionSort(){
		for(int i=1;i<arraySize;i++){
			int j=i;
			int valueToBeInserted= array[i];
			
			while((j>0)&&(array[j-1]>valueToBeInserted))
				{array[j]=array[j-1];
				j--;
		}
		array[j]=valueToBeInserted;
	}
	}
	
	/**
	 * 
	 * @param indexOne : first index value being compared
	 * @param indexTwo : second index value being compared
	 */
	public void swapIndex(int indexOne, int indexTwo){
		
		int temp=array[indexOne];
		array[indexOne]=array[indexTwo];
		array[indexTwo]=temp;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		Arrays arrayStructure=new Arrays();
		arrayStructure.randomArrayGenerator();
		arrayStructure.printArray();
		System.out.println("VALUE AT INDEX IS:"+arrayStructure.valueAtIndex(100));
		System.out.println("VALUE FOUND : "+arrayStructure.searchValue(8));
		System.out.println("Deleting value ..............");
		arrayStructure.deleteValueAtIndex(5);
		arrayStructure.printArray();
		System.out.println("Inserting value ..............");
		arrayStructure.insertValue(500);
		arrayStructure.printArray();
		System.out.println("Searching value ..............");
		arrayStructure.linearSearch(4);
		System.out.println("Bubble sort ascending..............");
		arrayStructure.bubbleSortAscending();
		arrayStructure.printArray();
		System.out.println("Bubble sort descending..............");
		arrayStructure.bubbleSortDescending();
		arrayStructure.printArray();
		System.out.println("Binary Search for value..............");
		arrayStructure.binarySearchForValue(4);
		arrayStructure.printArray();
		System.out.println("My sorting algorithm............");
		arrayStructure.someSortIcameUpWith();;
		arrayStructure.printArray();
		System.out.println("Selection sort algorithm............");
		arrayStructure.selectionSort();
		arrayStructure.printArray();
		System.out.println("Insertion sort algorithm............");
		arrayStructure.insertionSort();
		arrayStructure.printArray();
	}
}