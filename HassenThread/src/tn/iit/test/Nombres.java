package tn.iit.test;

public class Nombres {
	
	public static void main(String[] args) {
		Thread nb1, nb2, nb3;
		
//		nb1 = new Thread(new PrintNb(1));
//		nb1.start();
//		nb1.setPriority(Thread.MIN_PRIORITY);
		
		nb2 = new Thread(new PrintNb(22));
		nb2.start();
		nb2.setPriority(Thread.MAX_PRIORITY);
		
		nb3 = new Thread(new PrintNb(33));
		nb3.start();
		nb3.setPriority(Thread.NORM_PRIORITY);
		
		System.out.print("\n priorité actuelle : ");
		System.out.println(Thread.currentThread().getPriority());//toujour donne la valeur 5
		System.out.print("nombre de threads:" + Thread.activeCount());
	}
	
}