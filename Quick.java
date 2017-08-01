public class Program
{
	public static void main(String[] args) {
	    int[] arr = {7,31,5,29,60,8,14,9};
	    
	    quickSort(arr, 0, arr.length - 1);
	    
	    for(int i = 0; i < arr.length; i ++ ){
	        System.out.println(arr[i] + " ");
	        
	    }
	    System.out.println();
	    
		System.out.println(quickSelect(arr, 0, arr.length - 1, 3));
	}
	
	
	static int partition(int[] nums, int low, int high){
	    int pos = low;
	    int pivot = nums[high];
	    
	    for(int i = low; i < high; i ++){
	        if(nums[i] < pivot){
	            int temp = nums[i];
	            nums[i] = nums[pos];
	            nums[pos] = temp;
	            pos++ ;
	        }
	    }
	    
	    nums[high] = nums[pos];
	    nums[pos] = pivot;
	    
	    return pos;
	    
	} 
	
	static void quickSort(int[] nums, int low, int high){
	    
	    if(low < high){
	    
	        int part = partition(nums, low, high);
	    
	        quickSort(nums, low, part - 1);
	        quickSort(nums, part + 1, high);
	    
	    }
	    
	}
	
	static int quickSelect(int[] nums, int low, int high, int k){     //kth smallest number
	    
	    if(low < high){
	    
	        int part = partition(nums, low, high);
	    
	        if(part == k - 1)   return nums[part];
	        else if(part > k - 1)    return quickSelect(nums, low, part - 1, k);
	        else  return   quickSelect(nums, part + 1, high, k);
	    
	    }
	   return -1;
	}
	
	
}