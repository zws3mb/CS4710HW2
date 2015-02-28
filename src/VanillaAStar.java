import world.*;
import java.awt.Point;

public class VanillaAStar extends Robot {

	public VanillaAStar(World myWorld) {
		super();
		this.addToWorld(myWorld);
		Point start=myWorld.getStartPos();
		Point end=myWorld.getEndPos();
		int width=myWorld.numCols();
		int height=myWorld.numRows();
	}
	@Override
	public void travelToDestination() {
		// TODO Auto-generated method stub
		
	}

}
