package computer_master_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import computer_master_display.Display;

public class gameSetUp implements Runnable {

	private Thread thread;
	private Display display;
	private String title;
	private int width, height;
	private BufferStrategy buffer;
	private Graphics g;
	int y=0,x=0;

	public gameSetUp(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public void init() {
		display = new Display(title, width, height);

	}

	public synchronized void start() {
		if (thread == null) {

			thread = new Thread(this);
			thread.start();

		}
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	  public void tick(){
		   y+=1;
		  }
	  public void took(){
		   x+=1;
		  }
	public void render() {
		buffer = display.canvas.getBufferStrategy();
		if (buffer == null) {
			display.canvas.createBufferStrategy(3);
			return;
		}
		g = buffer.getDrawGraphics();
		g.clearRect(0, 0, width, height);//pour supprimer la trace

		g.setColor(Color.red);
		g.drawRect(x, y, 20, 20);

		
		// draw

		// manager.render(g);

		// draw end
		buffer.show();
		g.dispose();

	}

	@Override
	 public void run(){ 
	    init();
	    
	    int fps = 50;
	    double timePerUpdate = 1000000000/fps;
	    double delta = 0;
	    long outLoopTime = System.nanoTime();
	    
	    while(true){ 
	    	delta = delta + (System.nanoTime() - outLoopTime)/timePerUpdate;
	    	outLoopTime = System.nanoTime();
	    	if(delta >= 1){
	    		tick();
	    		took();
	           render();
	           delta--;
	    	}

	    }
	}

}
