import java.util.*;

public class Program
{
	public static void main(String[] args) {
		int[] input1 = {2,3,4,5};
		int input2 = 2000000000;
		System.out.println(countUneatenLeaves(input1, input2));
	}
	
	
	public static int countUneatenLeaves(int[] arr, int N){
	    
	    
	    int l = arr.length;
	    int result = 0;
	    
	    for(int i = 0; i < (1<<l); i++ ){
	        List<Integer> subset = new ArrayList<>();
	        for(int j = 0; j < l; j++ ){
	            if((i & (1<<j)) != 0){
	                subset.add(arr[j]);
	            }
	        }
	        
	        if(subset.size() == 0)  continue;
	        int lcmvalue = lcm(subset);
            
	        result += (int) Math.pow(-1, subset.size() + 1) * N/lcmvalue;
	    }
	    
	 return N - result;   
	    
	}
	
	public static int lcm(List<Integer> subset){
	    int result = subset.get(0);
	    
	    for(int i = 1; i < subset.size(); i++ )    result *= subset.get(i) / gcd(result, subset.get(i));
	    
	    return result;
	}
	
	
	public static int gcd(int a, int b){
	    if(b == 0)  return a;
	    else return gcd(b, a%b);
	}
	
	
}



-------------------------Long-------------------
import java.util.*;

public class Program
{
	public static void main(String[] args) {
		long[] input1 = {2L,3L,4L,5L,7L,23L};
		long input2 = 100000000000000000L;
		System.out.println(countUneatenLeaves(input1, input2));
	}
	
	
	public static long countUneatenLeaves(long[] arr, long N){
	    
	    
	    int l = arr.length;
	    long result = 0L;
	    
	    for(int i = 0; i < (1<<l); i++ ){
	        List<Long> subset = new ArrayList<Long>();
	        for(int j = 0; j < l; j++ ){
	            if((i & (1<<j)) != 0){
	                subset.add(arr[j]);
	            }
	        }
	        
	        if(subset.size() == 0)  continue;
	        long lcmvalue = lcm(subset);
            
	        result += (long) Math.pow(-1, subset.size() + 1) * N/lcmvalue;
	    }
	    
	 return N - result;   
	    
	}
	
	public static long lcm(List<Long> subset){
	    long result = subset.get(0);
	    
	    for(int i = 1; i < subset.size(); i++ )    result *= subset.get(i) / gcd(result, subset.get(i));
	    
	    return result;
	}
	
	
	public static long gcd(long a, long b){
	    if(b == 0)  return a;
	    else return gcd(b, a%b);
	}
	
	
}





