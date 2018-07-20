package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
