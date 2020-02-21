package GUI;

import java.awt.Graphics;
import javax.swing.JPanel;

import Core.GameOfLife;


public class CPanel extends JPanel implements Runnable {

	private Thread animator;
	
	private boolean toggle = false;
	GameOfLife mGoL = new GameOfLife();
	
	private static final int REFRESH_RATE = 1000;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private int rate = REFRESH_RATE;
	public void increaseRate() { rate+=100;}
	public void decreaseRate() { rate= rate - 100 < 0 ? 0 : rate - 100;}
	
		
	
	
	@Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mGoL.paint(g);	

    }
	
	public void refresh() {
		if(this.toggle) {
		mGoL.process();
		this.repaint();
		}
	}
	
	public void toggle() {
		this.toggle = !this.toggle;
		System.out.println(this.toggle);
	}
	
	/// Panel Refreshing on rate 
	@Override
	public void run() {		
		 while (true) {	          
            	           	          
            try {
            	
                Thread.sleep(rate);
                this.refresh();
            	
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }	           
        }			
	}
}
