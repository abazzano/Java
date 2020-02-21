package Core;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameOfLife implements IPaint {
	Grid mGrid;
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 100;
	public static final int HEIGHT =100;
	
	public static final int SCALE = 10;
	@SuppressWarnings("serial")
	public GameOfLife() 	{
		this.mGrid = new Grid(WIDTH, HEIGHT);
		
		this.mGrid.InitShape(new ArrayList<IShape>() {

		{ 
			//add(new Clignotant());
			//add(new Clignotant(new CPoint(10, 10))); 
			//add(new ConwellSurprise(new CPoint(50, 25)));
			add(new CanonPlaneur());
			}});
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		
		g.setColor(Color.CYAN);
		for(int i= 0; i < mGrid.getmWidth(); i++) {
			for(int j= 0; j < mGrid.getmHeight(); j++) {
				if(this.mGrid.getValue(i, j)) {
					//g.drawRect(i*SCALE, j*SCALE, 1*SCALE, 1*SCALE);
					g.fillRect(i*SCALE, j*SCALE, 1*SCALE, 1*SCALE);
				}
			}			
		}		
		
		g.setColor(c);
	}
	
	public void clear() {
		this.mGrid.InitGrid(false);
	}
	
	public void process() {
		
		Grid nGrid = new Grid(WIDTH, HEIGHT);
		
		// Iteration sur la grille pour compter combien de cellule "vivante" autour de la possition courante
		for(int i= 0; i < mGrid.getmWidth(); i++) {
			for(int j= 0; j < mGrid.getmHeight(); j++) {
				
				// Iteration sur les cellules "autour" de l'élément du tableau
				int indexMinX = i - 1 < 0 ? 0 : i-1;
				int indexMinY = j - 1 < 0 ? 0 : j-1;
				int indexMaxX = i + 1 == mGrid.getmWidth() ? i : i+1;
				int indexMaxY = j + 1 == mGrid.getmHeight() ? j : j+1;
				
				int nbCellActive = 0;
				
				for(int x = indexMinX; x <= indexMaxX; x++) {
					for(int y = indexMinY; y <= indexMaxY; y++) {
						if(this.mGrid.getValue(x, y) && !(x==i && y==j)) {							
							nbCellActive++;
						}
					}
				}
				
				// survie cellule
				if(this.mGrid.getValue(i, j)) {
					if(nbCellActive ==2 || nbCellActive==3) {
						// cellule entouré de 2 ou 3 autre cellue => elle reste en vie
						nGrid.setValue(i, j, true);
					}
				} else {
					// naissance si entouré de 3 cellules
					if(nbCellActive==3) {
						nGrid.setValue(i, j, true);
					}
				}
											
			}
		}
		
		// affectation de la nouvelle grille 
		this.mGrid = nGrid;
	}
		
}
