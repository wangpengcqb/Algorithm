import java.util.*;

public class ItemAssociation
{
	
	public static String[] maxAssociation(String[][] associations){
	    
	    if(associations == null || associations.length == 0)    return null;
	    
	    //Build graph
	    Map<String, List<String>> graph = new HashMap<>();
	    for(int i = 0; i < associations.length; i++ ){
	        //For any width of associations matrix
	        for(int j = 0; j < associations[0].length; j++){
	            if(!graph.containsKey(associations[i][j]))    graph.put(associations[i][j], new ArrayList<String>());
	            for(int k = 0; k < associations[0].length; k++){
	                if(k == j)    continue;
	                graph.get(associations[i][j]).add(associations[i][k]);
	            }
	        }
	        
	        /*
	        //Assume the width of associations matrix is 2
	        if(!graph.containsKey(associations[i][0]))    graph.put(associations[i][0], new ArrayList<String>());
	        graph.get(associations[i][0]).add(associations[i][1]);
	        
	        if(!graph.containsKey(associations[i][1]))    graph.put(associations[i][1], new ArrayList<String>());
	        graph.get(associations[i][1]).add(associations[i][0]);
	        */
	    }
        
	    
	    Set<String> visited = new HashSet<>();
	    
	    int maxLen = 0;
	    List<List<String>> result = new ArrayList<>();
	    
	    for(String key : graph.keySet()){
	        if(!visited.contains(key)){
	            List<String> temp = new ArrayList<>();
	            search(key, graph, visited, temp);
	            Collections.sort(temp);
	            
	            if(temp.size() > maxLen){
	                maxLen = temp.size();
	                result.clear();
	                result.add(temp);
	            }else if(temp.size() == maxLen){
	                result.add(temp);
	            }        
	            
	        }
	    }
	    
	    System.out.println(result);
	    
	    //List already sorted when using hashmap
	    return result.get(0).toArray(new String[result.get(0).size()]);
	}
	
	public static void search(String str, Map<String, List<String>> graph, Set<String> visited, List<String> temp){
	   
	    visited.add(str);
	    temp.add(str);
	    if(graph.containsKey(str)){
	        List<String> neighbors = graph.get(str);
	        for(String i : neighbors){
	            if(!visited.contains(i)){
	                search(i, graph, visited, temp);
	            }
	        }
	    }
	    
	}
	
	
	public static void main(String[] args) {
		String[][] input = {
		                    {"g", "w"},
		                    {"k", "m"},
		                    {"e", "g"},
		                    {"j", "b"},
		                    {"w", "i"},
		                    {"a", "m"},
		                    {"c", "a"}
		};
		
		String[] result = maxAssociation(input);
		
		for(String s : result){
		    System.out.print(s + "  ");
		}
		
		
	}
}
