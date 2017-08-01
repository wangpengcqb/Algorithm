public class Program
{
	public static void main(String[] args) {
		int[] input = {10,6,54,7,2,16,1,9};
		heapSort(input);
		
		for(int i = 0; i < input.length; i ++)     
		     System.out.println(input[i] + " ");
        
        System.out.println();
		    
	}
	
	
	public static void heapSort(int[] nums){
	    int n = nums.length;
	    
	    
	    for(int i = n/2 - 1; i >= 0; i --){
	        heapify(nums, n, i);
	    }
	    
	    for(int i = n - 1; i > 0; i -- ){
	        int temp = nums[0];
	        nums[0] = nums[i];
	        nums[i] = temp;
	        
	        heapify(nums, i, 0);
	        
	    }
	    
	    
	    
	}
	
	public static void heapify(int[] nums, int n, int i){
	    
	    int maxIndex = i;
	    int l = 2*i + 1;
	    int r = 2*i + 2;
	        
	    if(l < n && nums[l] > nums[maxIndex])    maxIndex = l;     
	    if(r < n && nums[r] > nums[maxIndex])    maxIndex = r;
	        
	   if(i != maxIndex){
	       int temp = nums[i];
	       nums[i] = nums[maxIndex];
	       nums[maxIndex] = temp;
	            
	       heapify(nums, n, maxIndex);
	   }
	    
	}
	
	
	    
	    
	public static int findkth(int[] nums, int k){
	    int n = nums.length;

	    for(int i = n/2 - 1; i >= 0; i --){
	        heapify(nums, n, i);
	    }
	    
	    for(int i = n - 1; i > n - k ; i -- ){
	        int temp = nums[0];
	        nums[0] = nums[i];
	        nums[i] = temp;
	        
	        heapify(nums, i, 0);
	        
	    }   
	    
	    return nums[0];
	    
	}
	
	
}