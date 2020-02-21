package Core;

import java.util.Arrays;
import java.util.List;

public class CanonPlaneur implements IShape {
	
	CPoint mOffset = new CPoint(20,50);
	CPoint[] shape = new CPoint[36];
	
	public CanonPlaneur() {
		// Construction de la forme 
		
		shape[0] = new CPoint(0, 3);
		shape[1] = new CPoint(1, 3);
		shape[2] = new CPoint(0, 4);
		shape[3] = new CPoint(1, 4);
		/////////
		shape[4] = new CPoint(13, 0);
		shape[5] = new CPoint(12, 0);
		shape[6] = new CPoint(11, 1);
		shape[7] = new CPoint(10, 2);
		shape[8] = new CPoint(10, 3);
		shape[9] = new CPoint(10, 4);
		shape[10] = new CPoint(11, 5);
		shape[11] = new CPoint(12, 6);
		shape[12] = new CPoint(13, 6);
		////////
		
		shape[13] = new CPoint(15, 1);
		shape[14] = new CPoint(15, 5);
		
		shape[15] = new CPoint(16, 2);
		shape[16] = new CPoint(16, 3);
		shape[17] = new CPoint(16, 4);
		
		shape[18] = new CPoint(14, 3);
		shape[19] = new CPoint(17, 3);
		////////
		
		shape[20] = new CPoint(20, 4);
		shape[21] = new CPoint(21, 4);
		shape[22] = new CPoint(20, 5);
		shape[23] = new CPoint(21, 5);
		shape[24] = new CPoint(20, 6);
		shape[25] = new CPoint(21, 6);
		
		shape[26] = new CPoint(22, 3);
		shape[27] = new CPoint(22, 7);
		shape[28] = new CPoint(24, 3);
		shape[29] = new CPoint(24, 7);
		shape[30] = new CPoint(24, 2);
		shape[31] = new CPoint(24, 8);
		
		////////
		shape[32] = new CPoint(34, 5);
		shape[33] = new CPoint(35, 5);
		shape[34] = new CPoint(34, 6);
		shape[35] = new CPoint(35, 6);
		
	}
	public CanonPlaneur(CPoint pOffset) {
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