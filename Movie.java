
public abstract class Movie {

	private double user_rating; 
	protected final int YEAR_RELEASED; 
	protected final int DURATION; 
	protected final String TITLE;
	
	//constructor 
	public Movie (String title, int year, int duration, double rating){
		//if rating is not 0,1,2,3 or 4
		if (rating < 0 || rating > 4){
			throw new IllegalArgumentException ("Please enter a valid rating.");
		}
		// if year is not between 1870 and 2015 incl.
		if (year < 1870 || year > 2015){
			throw new IllegalArgumentException ("Please enter a valid year between 1870 and 2015.");
		}
		// if duration is not a positive integer
		if (duration < 0){
			throw new IllegalArgumentException ("The duration of the film must be greater than 0.");
		}
		this.DURATION = duration; 
		this.TITLE = title; 
		this.YEAR_RELEASED = year; 
		this.user_rating = rating; 
	}
	//getter and setter for user_rating
	public double getRating(){
		return this.user_rating;
	}
	public void setRating(double rating){
		if (rating < 0 || rating > 4){
			throw new IllegalArgumentException ("Please enter a valid rating.");
		}
		this.user_rating = rating; 
	}
	
	//getters for FINAL variables
	public int getYearReleased(){
		return this.YEAR_RELEASED;
	}
	public int getDuration(){
		return this.DURATION;
	}
	public String getTitle(){
		return this.TITLE;
	}
	
	
	
	//TITLE: YEAR_RELEASED, rating: RATING, price: PRICE
	public String toString(){ 
		String s = String.format("%s: %d, rating: %f, price:%f", TITLE, YEAR_RELEASED, user_rating, getPrice());
		return s; 
	}
	
	public abstract double getPrice();
	
	
}
