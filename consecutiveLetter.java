input: "priistiistoomdd"
output:"i, i, o, d"

input:"priiistiistoomdd".
output:"i"




public class Solution{
	public List<Character> findChar(String str){
		if(str.length() == 0 || str == null) return new ArrayList<Character>();
		
		char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
		
		int maxlen = 0;
		int len = 1;
		char temp = arr[0];
		
		for(int i = 1; i < arr.length; i ++ ){
		    if(arr[i] == arr[i - 1]){
                  len ++;
                  continue;
            }else if(len == maxlen){
			     list.add(arr[i - 1]);
			}else if(len > maxlen){
			      list.clear();
				  list.add(arr[i - 1]);
				  maxlen = len;
			}
             len = 1;
        }			
		
		if(len == maxlen)  list.add(arr[arr.length - 1]);
	
	return list;	

 }
}
