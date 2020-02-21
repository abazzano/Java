package Core;

import java.util.Arrays;
import java.util.List;



public class ConwellSurprise implements IShape {
	
	CPoint mOffset = new CPoint(4,4);
	CPoint[] shape = new CPoint[5];
	
	public ConwellSurprise() {
		// Construction de la forme Clignotant
		shape[0] = new CPoint(1, 0);
		shape[1] = new CPoint(2, 0);
		shape[2] = new CPoint(0, 1);
		shape[3] = new CPoint(1, 1);
		shape[4] = new CPoint(1, 2);
		
	}
	public ConwellSurprise(CPoint pOffset) {
		this();
		// Définition de l'offset
		if(pOffset != null) {
			this.mOffset = new CPoint(pOffset.mXPos, pOffset.mYPos);
		}
				
	}

	@Override
	public CPoint getOffset() {
		// TODO Auto-generated method stub
		return this.mOffset;
	}

	@Override
	public List<CPoint> getShape() {
		// TODO Auto-generated method stub
		return Arrays.asList(this.shape);
	}
}