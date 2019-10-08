package tn.iit.test;

import java.lang.*;

public class ThreadDemo {

	public static void main(String[] args) {

		Thread t = Thread.currentThread();
		t.setName("Admin Thread");

		// set thread priority to 1
		t.setPriority(1);

		// prints the current thread
		System.out.println("Thread = " + t);

		int count = Thread.activeCount();
		System.out.println("currently active threads = " + count);

		Thread th[] = new Thread[count];
		// returns the number of threads put into the array
		Thread.enumerate(th);
		/*
		 * The java.lang.Thread.enumerate() method copies into the specified array every
		 * active thread in the current thread's thread group and its subgroups. It
		 * calls the enumerate method of the current thread's thread group with the
		 * tarray argument.
		 */

		// prints active threads
		for (int i = 0; i < count; i++) {
			System.out.println(i + ": " + th[i]);
		}
	}
}