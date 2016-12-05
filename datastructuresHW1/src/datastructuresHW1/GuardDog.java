package datastructuresHW1;

public class GuardDog extends Dog {
	private short meannesss;
	
	@Override
	public String move() {
		String move = "Runs after you on four legs.";
		return move;
	}
	
	@Override
	public String makeSound() {
		String sound = "Growls meanly.";
		return sound;
	} 
	
	float getMeannesss() {
		return meannesss;
	}

	public void setMeannesss(short meannesss) {
		this.meannesss = meannesss;
	}
}
