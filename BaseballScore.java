import java.util.*;

public class BaseballScore
{
	
	
	public static int calScore(String[] strs){
	    
	    Stack<Integer> scores = new Stack<>();
	    
	    int result = 0;
	    int curNum;
	    int preNum;
	    int prePreNum;
	    char curChar;
	    
	    if(strs == null || strs.length == 0)    return result;
	    
	    for(String s : strs){
	        if( (s.charAt(0) > '0' && s.charAt(0) <= '9') || s.charAt(0) == '-' ){
	            try{
	                curNum = Integer.parseInt(s);
	                result += curNum;
	                scores.add(curNum);
	            }catch(NumberFormatException nfe){
	                return 0;
	            }
	        }else if(s.charAt(0) == 'X'){
	            if(scores.isEmpty())    preNum = 0;    
	            else    preNum = scores.peek();
	            result += preNum*2;
	            scores.add(preNum*2);
	        }else if(s.charAt(0) == '+'){
	            if(scores.isEmpty()){
	                scores.add(0);
	            }else{
	                preNum = scores.pop();
	                if(scores.isEmpty())    prePreNum = 0;
	                else    prePreNum = scores.peek();
	                result += preNum + prePreNum;
	                scores.add(preNum);
	                scores.add(preNum + prePreNum);
	            }
	        }else if(s.charAt(0) == 'Z'){
	            if(!scores.isEmpty()){
	                preNum = scores.pop();
	                result -= preNum;
	            }
	            
	        }else    return 0;     //illegal input string
	    }
	    return result;
	}
	
	
	
	public static void main(String[] args) {
		String[] input = new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"};
		
		int val = calScore(input);
		System.out.println(val);
	}
}