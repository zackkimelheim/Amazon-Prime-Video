
import java.util.*; 

public class Inventory{
	private ArrayList<Movie> list = new ArrayList<Movie>();
	
	//returns true if list DOES contain the movie already
	public boolean contains(String title, int year){
		boolean result = false;
		for (Movie m: list){
			if (m.TITLE.equals(title)){
				if (m.YEAR_RELEASED == year){
				result = true; 
				break;
				}
			}
		}
		return result; 
	}
	
	//returns the size of the list
	public int size(){
		return list.size();
	}
	
	//adds a movie to the list (if...)
	public void add(Movie newMovie){
		
		//if newMovie is already in the inventory list, then throw exception and don't add
		if (contains(newMovie.TITLE,newMovie.YEAR_RELEASED)){
			throw new MovieInventoryException("The movie already exists in the inventory."); 
		}
		//if newMovie is not in the inventory, then add it!
		else {
			list.add(newMovie);
		}
	}
	
	//removes a movie from the list (if...)
	public boolean remove(String title, int year){
		boolean result = false; 
		if (contains(title,year)){
			Iterator<Movie> iterator = list.iterator(); //create list iterator to traverse through the list
			Movie movie; //create this to manipulate removal in loop below
			while (iterator.hasNext()){
				movie = iterator.next();
				if (movie.YEAR_RELEASED == year){
					if (movie.TITLE.equals(title)){
						iterator.remove();
					}
				}
			}
			result = true;
		}
		return result; 
	}
	
	//returns elongated string of the entire list array of movies 
	public String toString(){
		String listStr = "";
		for (Movie m: list){
			listStr += m.toString() + "\n";
		}
		return listStr; 
	}
	
}
