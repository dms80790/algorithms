
public class Heap {
	private Word[] array;      //holds a reference to the array passed to the class
	private int z = 499;       //holds the last index of interest in the array for removeMax()
	
	/*constructor calls buildHeap method
	*/
	public Heap(Word[] array){
		this.array = array;
		buildHeap(array);
	}//end constructor
	
	// Problem #2
	// Fill in this method with an O(n) time algorithm
	// that builds an n element complete binary heap.
	// Note: You are allowed to add and modify fields
    // and helper methods.
	public void buildHeap(Word[] array){	
		int numElements = array.length;        //holds the number of elements in the array
		for(int index = (numElements)/2; index >= 0; index--)
			sink(array, index, numElements);
		
	}//end buildHeap
	
	public Word removeMax(){
	// Problem #3
	// Fill in this method with an O(log(n)) time algorithm
	// that removes the root element, restores the heap
	// structure, and finally returns the removed root element.
			Word maxElement = array[0];
			
			exchange(array, 0, z--);     //exchange the contents of array[0] with the last element of the heap, then decrement the last element
			sink(array, 0, z);           //restore the order to the heap by sinking the new root through the heap
			
			return maxElement;           //return the maximum element in the heap
	}//end removeMax
	
	public Word[] select(int size){
		Word[] result = new Word[size];
		for(int i = 0; i < size; i++){
			
			result[i] = this.removeMax();
		}
		return result;
	}//end select
	
	/*
	private void swim(Word[] array, int index){
		while(index > 1 && less(array, (index/2), index)){
			exchange(array, (index/2), index);
			index = index/2;
		}//end while
	}//end swim
	*/
	
	private void sink(Word[] array, int index, int numElements){
		while( 2*index < numElements){
			int j = 2*index;
			if(j < numElements && less(array, j, j+1))      //if key at j is less than key at j+1, go to j+1
				j++;
			if(!less(array, index,j))                       //if the key at the index is not less than the key at j, break
				break;
			exchange(array, index,j);                       //exchange the array elements at index and j
			index = j;                                      //update the index value to j
		}//end while
	}//end sink
	
	private boolean less(Word[] array, int index, int nextIndex){
		return array[index].compareTo(array[nextIndex]) < 0;
	}//end less
	
	private void exchange(Word[] array, int i, int j){
		Word temp = array[i];
		array[i] = array[j];
		array [j] = temp;
	}//end exchange
}//end Heap