package Core;

import java.util.List;

public class Grid {

	private int mWidth;
	private int mHeight;
	private boolean[][] mGrid;

	public Grid(int pWidth, int pHeight) {
		if (pHeight > 0 && pWidth > 0) {
			this.setmHeight(pHeight);
			this.setmWidth(pWidth);
			this.mGrid = new boolean[this.getmWidth()][this.getmHeight()];
		}
		else {
			throw new ArithmeticException("Grid dimension is not valide");
		}
		
		this.InitGrid(false);
	}

	public void InitGrid(boolean pdefaultValue) {
		for(int i= 0; i < this.getmWidth(); i++) {
			for(int j= 0; j < this.getmHeight(); j++) {
				this.mGrid[i][j] = pdefaultValue;
			}			
		}
	}
	
	public void InitShape(List<IShape> pShape) {
		
		// TODO Envoyer une exception
		if(mGrid == null || pShape == null) return;
		
		// On itère sur la collection pour créer les formes dans la grille
		for(IShape s : pShape) {
			CPoint o = s.getOffset();
			List<CPoint> shape = s.getShape();
			for(CPoint p : shape) {
				if(p.mXPos + o.mXPos < this.getmWidth() && p.mYPos + o.mYPos < this.getmHeight()
						&& p.mXPos + o.mXPos >=0 && p.mYPos + o.mYPos >=0)
					this.mGrid[p.mXPos + o.mXPos][p.mYPos + o.mYPos] = true; 
			}								
		}		
	}
	
	public boolean getValue(int pxPos, int pyPos) {
		return this.mGrid[pxPos][pyPos];
	}
	
	public void setValue(int pxPos, int pyPos, boolean value) {
		this.mGrid[pxPos][pyPos] = value;
	}

	public int getmWidth() {
		return mWidth;
	}

	public void setmWidth(int mWidth) {
		this.mWidth = mWidth;
	}

	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}
}
