public class Philo extends Thread{
	private boolean  fd=false,fg=false;
	private Semaphore smd,smg;
	private ImagePanel ip;
	public Philo(int id,Semaphore smg,Semaphore smd){
		this.smd = smd;
		this.smg = smg;
		ip = new ImagePanel(id);
	}
	public ImagePanel getPanel(){
		return ip;
	}
	private void upDatePanel(){
		if(fd== true && fg==true ){
			ip.setAvec();
			return ;
		}
		if(fd== false && fg==false ){
			ip.setSans();
			return ;
		}
		if(fd== true && fg==false){
			ip.setDroite();
			return ;
		}
		if(fd== false && fg==true ){
			ip.setGauche();
			return ;
		}
	}
	private void setFourchetteDroite(){
		smd.waitD();
		fd=true;
		upDatePanel();
	}
	private void setFourchetteGauche(){
		smg.waitD();
		fg=true;
		upDatePanel();
	}
	private void disposeFourchettes(){
		fd=fg=false;
		smd.signal();
		smg.signal();
		upDatePanel();
	}
	private void manger(){
		try {
			sleep(2000);
			}
			catch (Exception ex) {
			}
	}
	private void pencer(){
		try {
			sleep(4000);
			}
			catch (Exception ex) {
			}
	}
	
	public void run(){
		while (true) {
		setFourchetteDroite();
		setFourchetteGauche();
		manger();
		pencer();	
		disposeFourchettes();
	    }
	}
}