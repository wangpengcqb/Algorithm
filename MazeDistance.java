import java.util.*;


public class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Node{
    Point p;
    int dist;
    Node(Point p, int dist){
        this.p = p;
        this.dist = dist;
    } 
}


public class MazeDistance
{
    
    public static int BFS(int[][] mat, Point src, Point dest){
	    int m = mat.length;
	    int n = mat[0].length;
	    
	    if(mat[src.x][src.y] == 1 || mat[dest.x][dest.y] == 1)    return -1;
	    
	    
	    int dist = 0;
	    int[][] visited = new int[m][n];
	    
	    
	    //neighbor matrix
	    int[] rowNum = {-1, 0, 0, 1};
	    int[] colNum = {0, -1, 1, 0};
	    
	    //mark the source cell
	    visited[src.x][src.y] = 1;
	    
	    Queue<Node> q = new LinkedList<>();
	    Node start = new Node(src, dist);
	    
	    q.add(start);
	    
	    while(!q.isEmpty()){
	        Node cur = q.poll();
	        
	        if(cur.p.x == dest.x && cur.p.y == dest.y)    return cur.dist;
	        
	        
	        for(int i = 0; i < 4; i++){
	            int row = cur.p.x + rowNum[i];
	            int col = cur.p.y + colNum[i];
	            
	            boolean isValid = (row >= 0)&&(row < m)&&(col >= 0)&&(col < n);
	            
	            if(isValid&&(mat[row][col]==0)&&(visited[row][col]==0)){
	                visited[row][col] = 1;
	                Point pt = new Point(row, col);
	                Node adj = new Node(pt, cur.dist+1);
	                q.add(adj);
	            }
	            
	        }
	        
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
        int[][] mat =
        {
        { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
        { 0, 1, 0, 1, 0, 0, 0, 1, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 1, 0, 1, 0 },
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
        { 0, 1, 0, 0, 0, 0, 1, 0, 1, 1 },
        { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
        { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
        { 0, 0, 1, 1, 1, 1, 0, 1, 1, 0 }
        };
    
    Point source = new Point(0, 0);
    Point dest = new Point(8, 1);
    
    int dist = BFS(mat, source, dest);
    
    System.out.println(dist);
    
	}
	
	
	
	
}