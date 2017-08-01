import java.util.*;

public class Movie {
    private int id;
    private float rating;
    private List<Movie> similarMovies;

    public Movie(int id, float rating) {
        this.id = id;
        this.rating = rating;
        this.similarMovies = new ArrayList<>();
    }
    
    public void AddRelatedMovie(Movie movie){
        this.similarMovies.add(movie);
        movie.similarMovies.add(this);
    }
    
    public float getRating(){
        return rating;
    }

    public int getId(){
        return id;
    }
    public List<Movie> getSimilarMovies(){
        return similarMovies;
    }
    
    @Override
    public String toString(){
        return "Movie{" + this.id + '}' + "    " + "Rating(" + this.rating + ')';
    }
}


public class MovieNetwork
{
    
    
    public static Set<Movie> getMovieRecommendations(Movie movie, int N){
        
        Set<Movie> result = new HashSet<>();
        
        PriorityQueue<Movie> minHeap = new PriorityQueue<Movie>(N+1, 
        (x, y) -> Float.compare(x.getRating(), y.getRating())
        
        );
        
        
        Set<Movie> visited = new HashSet<>();
        Queue<Movie> q = new LinkedList<>();
        
        q.offer(movie);
        
        while(!q.isEmpty()){
            Movie cur = q.poll();
            
            //Add element first, and then pop the smallest rating if greater than N
            if(cur.getId() != movie.getId())    minHeap.add(cur);    //Igore the movie itself
            if(minHeap.size() > N)    minHeap.poll();
            
            visited.add(cur);
            
            for(Movie neighbor : cur.getSimilarMovies()){
                if(!visited.contains(neighbor)){
                    q.offer(neighbor);
                }
            }
        }
        
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        return result;
    }
    
    
	public static void main(String[] args) {
		Movie a = new Movie(1, 1.2f);
		Movie b = new Movie(2, 3.3f);
		Movie c = new Movie(3, 2.7f);
		Movie d = new Movie(4, 4.6f);
		Movie e = new Movie(5, 3.8f);
		Movie f = new Movie(6, 4.2f);
		Movie g = new Movie(7, 5.0f);
		Movie h = new Movie(8, 2.3f);
		Movie i = new Movie(9, 4.4f);
		Movie j = new Movie(10, 1.9f);
		
		a.AddRelatedMovie(b);
		a.AddRelatedMovie(c);
		a.AddRelatedMovie(g);
		b.AddRelatedMovie(d);
		d.AddRelatedMovie(f);
		e.AddRelatedMovie(g);
		h.AddRelatedMovie(i);
		i.AddRelatedMovie(c);
		j.AddRelatedMovie(i);
		
		
		Set<Movie> all = getMovieRecommendations(a, 5);
		
		
		for(Movie movie : all){
		    System.out.println(movie);
		}
		
	}
}