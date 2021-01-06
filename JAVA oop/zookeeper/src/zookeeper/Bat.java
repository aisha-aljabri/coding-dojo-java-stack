package zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void flying() {
		System.out.println("screech screech screech");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("well, never mind");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Fire Fire Fire");
		this.energyLevel -= 100; 
	}

}
