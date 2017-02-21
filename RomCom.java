
public class RomCom extends Movie {
	private int jerks;
	private int friendzones; 
	
	//getters and setters for class variables
	public void setJerks(int jerks){
		if (jerks < 1 || jerks > 10){
			throw new IllegalArgumentException("Number of jerks must be between 1 and 10.");
		}
		this.jerks = jerks; 
	}
	public int getJerks(){
		return this.jerks; 
	}
	public void setFriendzones(int friendzones){
		if (friendzones < 1 || friendzones > 10){
			throw new IllegalArgumentException("Number of boyfriends must be between 1 and 10.");
		}
		this.friendzones = friendzones; 
	}
	public int getFriendzones(){
		return this.friendzones; 
	}

	//RomCom constructor 
	public RomCom(String title, int year, int duration, double rating, int jerks, int friendzones){
		super(title,year,duration,rating);
		setJerks(jerks);
		setFriendzones(friendzones);
	}
	@Override //new toString method
	public String toString(){
		String s = String.format("%s: %d, rating: %f, price: %f, jerks: %d, friendzones: %d", TITLE, YEAR_RELEASED, getRating(), getPrice(),getJerks(),getFriendzones());
		return s; 
	}
	
	@Override //new getPrice method
	public double getPrice(){
		return (this.jerks + this.friendzones +
				this.YEAR_RELEASED - this.DURATION) / 100;
	}

}