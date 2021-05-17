package Core;

import GUI.CFrame;

public class CMain {

	// ENTRY POINT 
	public static void main(String[] args) {
		// Frame creation
		CFrame defaultFrame = new CFrame("Le Jeu de la vie");
									
		defaultFrame.setDefaultCloseOperation(CFrame.EXIT_ON_CLOSE);
		
		//4. Size the frame.
		defaultFrame.pack();
		
		//5. Show it.
		defaultFrame.setVisible(true);
		
	}

}
