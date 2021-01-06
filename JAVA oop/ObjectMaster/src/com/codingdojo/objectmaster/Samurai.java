package com.codingdojo.objectmaster;

public class Samurai extends Human{
	static int counter = 0;
	
	public Samurai() {
		this.counter +=1;
		this.health=200;
	}
	
	public void deathBlow(Human h) {
		h.health =0;
		this.health += (this.health/2);
	}
	
	public void meditate() {
		this.health += (this.health/2);
	}
	
	public int howMany() {
		return counter;
	}

}
