package datastructuresHW1;

public class Dog implements Animal {
	private String furColor;
	
	@Override
	public String move() {
		String move = "Walk on four legs.";
		return move;
	}

	@Override
	public String makeSound() {
		String sound = "Bark.";
		return sound;
	}
	
	public String getFurColor(){
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

}
