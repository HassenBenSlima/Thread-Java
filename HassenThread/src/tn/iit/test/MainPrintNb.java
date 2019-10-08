package tn.iit.test;

public class MainPrintNb {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		/*
		 * methode 1:
		 *Thread nb1=new PrintNb(1) ;
		Thread nb2=new PrintNb(2);
		Thread nb3=new PrintNb(3);
		nb1.start; 
		 * 
		 * 
		 * */
		Thread nb1;
		Thread nb2;
		Thread nb3;

		
		nb1 = new Thread(new PrintNb(1));
		nb2 = new Thread(new PrintNb(2));
		nb3 = new Thread(new PrintNb(3));

		/*nb1.setPriority(Thread.MAX_PRIORITY);
		nb2.setPriority(Thread.NORM_PRIORITY);
		nb3.setPriority(Thread.MIN_PRIORITY);
		*/
		//System.out.println("\n"+nb1.getPriority());
		
		nb1.start();
		//nb1.join();
		
		nb2.start();
		//nb2.join();
		
		nb3.start();
		
			
	//	nb1.start();
		
		
		
	/*	System.out.println("\n"+Thread.MAX_PRIORITY);
		//nb1.join();
		System.out.println("\n"+Thread.MIN_PRIORITY);
		System.out.println();*/
//nb1.join();
//nb2.join();

	//	System.out.println("\n"+Thread.MIN_PRIORITY);
		
	}

}
