
public class Selector {
	
	private static void swap(Word[] array, int i, int j){
		
		Word temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/*
		Method to convert a larger array to a smaller k-element array
		@param array The array being converted
		@param k The size of the new array
	*/
	private static Word[] kArray(Word[] array, int k){
		Word[] shortArray = new Word[k];    //creates a new Word[] in memory of size k
			
		//convert to a k-element array
		for(int q = 0; q < k; q ++){
			shortArray[q] = array[q];
		}
		return shortArray;
	}//end kArray
	
	public static Word[] select(Word[] array, int k){
	// Problem #1
	// Fill in this method with an O(n*k) time algorithm
	// that returns the k largest elements of array in
	// order from largest to smallest.
	// Note: This should return an array with k elements.
	
		for(int i = 0; i < array.length; i++){
			int max = i;     //set the maximum to the index at which we are currently using
		
			for(int j = i + 1; j < array.length; j++){      //compare the element at i with the rest of the elements in the array
				if(array[i].compareTo(array[j]) < 0){
					max = j;
					swap(array, i, max);     //swap the contents of the array at index i with the contents of the max index 
					}//end if
			}//end inner for
		}//end outer for
		
		//create and return a k-sized array
		Word[] shortArray;     //holds the adjusted array with k elements
		shortArray = kArray(array, k);
		return shortArray;    //returns the sorted array with k elements in descending order of frerquency
	}//end select
}//end Selector