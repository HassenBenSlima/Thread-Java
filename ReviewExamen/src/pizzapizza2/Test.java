package pizzapizza2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://vijinimallawaarachchi.wordpress.com/2017/06/21/the-pizza-problem-concurrent-programming/
 */

/**
 *
 * @author Vijini
 */

public class Test {

	public static void main(String[] args) {
		StudyGroup studyGroup = new StudyGroup(); // Create student group
		int students = 6;

		for (int i = 0; i < students; i++) {
			new Student(studyGroup).start(); // Create Student threads
		}

		new PizzaDelivery(studyGroup).start(); // Create Pizza Delivery thread
	}
}




