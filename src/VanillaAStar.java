import world.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import Manhattan
public class VanillaAStar extends Robot {
	public Point start;
	public Point end;
	public int width;
	public int height;
	public VanillaAStar(World myWorld) {
		super();
		this.addToWorld(myWorld);
		start=myWorld.getStartPos();
		end=myWorld.getEndPos();
		width=myWorld.numCols();
		height=myWorld.numRows();
	}

	private ArrayList<Point> AStar(Heuristic heur){
		ArrayList<Point> path = new ArrayList<Point>();
		
		HashMap<Point,Double> map = new HashMap<Point,Double>();
		
		for(int x;x<this.width; x++){
			for(int y;y<this.height;y++){
				map.put(new Point(x,y),heur.score(this.end,new Point(x,y)));
			}
		}
		Point curr=this.start;
		HashMap<Point,Integer> closed= new HashMap<Point,Integer>();
		while(curr!=this.end){
			
			double x = curr.getX();
			double y = curr.getY();
			Point attempt = Collections.min(map);
			if (this.pingMap(attempt).equals("O")){
				curr=attempt;
				path.add(attempt);
			}
			map.remove(attempt);
		}
		return path;
	}
	public void travelToDestination() {
		// TODO Auto-generated method stub
		Point currpos = this.getPosition();
		ArrayList<Point> pathway = this.AStar(new Manhattan());
		for(Point next : pathway){
			this.move(next);
		}
	}

}
