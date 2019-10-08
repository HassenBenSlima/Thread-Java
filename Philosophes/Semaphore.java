import java.util.LinkedList;
public class Semaphore{
	private int val;
	private LinkedList file;
	
	public Semaphore(int v){
		file  = new LinkedList();
		init(v);
	}
	
	synchronized void init(int v){
		val =v;
	}
	
	synchronized void waitD(){
		val--;
		if(val<0){
			file.add(Thread.currentThread());
			try {
				wait();
		    }
		    catch (Exception ex) {
		    System.out.println ("erreur dans wait()");
		    }
		    file.remove(Thread.currentThread());
		}
	}
	synchronized void signal(){
		val++;
		if(val<=0)
		notifyAll();
	}
}