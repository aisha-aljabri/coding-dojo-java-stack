package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human h1 = new Human();
		Human h2 = new Human();
		
		h1.attack(h2);
		System.out.println("human1: "+h1.health);
		System.out.println("human2: "+h2.health);

	}

}
