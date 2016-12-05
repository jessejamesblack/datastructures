package datastructuresHW1;

public class ShowDog extends Dog{
	private String breed;
	
	@Override
	public String move() {
		String move = "Trots on four legs.";
		return move;
	}

	@Override
	public String makeSound() {
		String sound = "Small bark.";
		return sound;
	}
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
