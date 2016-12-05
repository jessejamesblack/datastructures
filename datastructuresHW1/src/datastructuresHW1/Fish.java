package datastructuresHW1;

public class Fish implements Animal {
	private String Color;
	
	@Override
	public String move() {
		String move = "Swims.";
		return move;
	}

	@Override
	public String makeSound() {
		String sound = "Bubbles moving.";
		return sound;
	}
	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

}
