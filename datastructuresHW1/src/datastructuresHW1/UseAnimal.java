package datastructuresHW1;

public class UseAnimal {

	public static void main(String[] args) {
		final int MAX = 4;
		Animal animals[] = new Animal[MAX];
		animals[0] = new Dog();
		animals[1] = new ShowDog();
		animals[2] = new GuardDog();
		animals[3] = new Fish();
		
		((Dog) animals[0]).setFurColor("Brown."); 
		((ShowDog) animals[1]).setBreed("Australian Shepherd.");
		((GuardDog) animals[2]).setMeannesss((short) 5);
		((Fish) animals[3]).setColor("Blue.");
		
		System.out.println("Normal for loop.");
		for(int i = 0; i < animals.length; i++){
			System.out.println(animals[i].getClass().getName());
			System.out.println(animals[i].makeSound());
			System.out.println(animals[i].move());
			if(animals[i].getClass().getName() == "datastructuresHW1.Dog")
			{
				System.out.println(((Dog) animals[i]).getFurColor());
			}
			if(animals[i].getClass().getName() == "datastructuresHW1.ShowDog")
			{
				System.out.println(((ShowDog) animals[i]).getBreed());
			}
			else if(animals[i].getClass().getName() == "datastructuresHW1.GuardDog")
			{
				System.out.println(((GuardDog) animals[i]).getMeannesss());
			}
			else if(animals[i].getClass().getName() == "datastructuresHW1.Fish")
			{
				System.out.println(((Fish) animals[i]).getColor());
			}
			System.out.println("");
		}
		System.out.println("Weird for loop.");
		for(Animal animal: animals)
		{
			System.out.println(animal.getClass().getName());
			System.out.println(animal.makeSound());
			System.out.println(animal.move());
			if(animal.getClass().getName() == "datastructuresHW1.Dog")
			{
				System.out.println(((Dog) animal).getFurColor());
			}
			if(animal.getClass().getName() == "datastructuresHW1.ShowDog")
			{
				System.out.println(((ShowDog) animal).getBreed());
			}
			else if(animal.getClass().getName() == "datastructuresHW1.GuardDog")
			{
				System.out.println(((GuardDog) animal).getMeannesss());
			}
			else if(animal.getClass().getName() == "datastructuresHW1.Fish")
			{
				System.out.println(((Fish) animal).getColor());
			}
			System.out.println("");
		}
	}
}