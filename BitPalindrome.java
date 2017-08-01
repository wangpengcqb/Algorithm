public class BitPalindrome
{
	
	public static boolean isPal(int x){
	    if(x < 0 || (x != 0 && x%2 == 0))    return false;
	    int rev = 0;
	    while(x > rev){
	        rev = rev*2 + x%2;
	        x = x/2;
	    }
	    
	    return (x == rev || x == rev/2);
	}
	
	public static void main(String[] args) {
		int input = 119;
		
		System.out.println(isPal(input));
		
	}
}