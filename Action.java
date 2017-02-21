
public class Action extends Movie {
	
	
	private int explosions; 
	
	//getter and setter for explosion variable
	public int getExplosions(){
		return this.explosions;
	}
	public void setExplosions(int explosions){
		if (!(explosions >= 1 && explosions <= 100)){
			throw new IllegalArgumentException("Explosions must be between 1 and 100.");
		}
		this.explosions = explosions; 
	}
	
	//constructor 
	public Action(String title, int year, int duration, double rating, int explosions){
		super(title,year,duration,rating);
		setExplosions(explosions);
	}
	
	@Override //super method toString
	public String toString(){
		String s = String.format("%s: %d, rating: %f, price:%f, explosions:%d", TITLE, YEAR_RELEASED, getRating(), getPrice(),getExplosions() );
		return s; 
	}
	
	@Override //abstract method GetPrice
	public double getPrice(){
		return (this.YEAR_RELEASED + this.explosions * this.DURATION) / 1000;
	}

}
