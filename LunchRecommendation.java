import java.util.*;

public class LunchRecommendation
{
    
    public static String[][] recommend(String[][] list1, String[][] list2){
        
        Map<String, Set<String>> menu = new HashMap<>();
        
        for(String[] line : list2){
            if(!menu.containsKey(line[0]))    menu.put(line[0], new HashSet<String>());
            menu.get(line[0]).add(line[1]);
        }
        
        List<String[]> result = new ArrayList<>();
        
        for(String[] line : list1){
            if(line[1] == "*"){
                for(Set<String> value : menu.values()){
                    for(String each: value){
                        result.add(new String[]{line[0], each});
                    }
                }
                
            }else if(menu.containsKey(line[1])){
                for(String each: menu.get(line[1])){
                    result.add(new String[]{line[0], each});
                }
            }else continue;
            
        }
        return result.toArray(new String[result.size()][]);
    }
    
    
	public static void main(String[] args) {
	    String[][] list1 = new String[][]{
	        {"Leon", "Chinese"},
	        {"Andrew", "American"},
	        {"Yean", "Japanese"},
	        {"Won", "Korean"},
	        {"Qian", "Chinese"},
	        {"Kevin", "*"}
	    };
	    
	    String[][] list2 = new String[][]{
	        {"Chinese", "Spicy Chicken"},
	        {"Chinese", "Mapo Tofu"},
	        {"American", "Sandwitch"},
	        {"American", "Steak"},
	        {"Korean", "BBQ"},
	        {"Mexico", "Taco"}
	    };
	    
		String[][] result = recommend(list1, list2);
		
		for(String[] row : result){
		    for(String elem : row){
		        System.out.print(elem + "     ");
		    }
		    System.out.println();
		}
	}
}