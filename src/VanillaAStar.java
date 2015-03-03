import world.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.SortedMap;
public class VanillaAStar extends Robot {
	public Point start;
	public Point end;
	public int width;
	public int height;
	public Heuristic h;
	public VanillaAStar(World myWorld,Heuristic hput) {
		super();
		this.addToWorld(myWorld);
		start=myWorld.getStartPos();
		end=myWorld.getEndPos();
		width=myWorld.numCols();
		height=myWorld.numRows();
		h=hput;
	}

	private ArrayList<Point> AStar(Heuristic heur){
		ArrayList<Node> path = new ArrayList<Node>();
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		open.add(new Node(this.start,0.0,h.score(this.start,this.start)));
		Node curr;
		while(!open.isEmpty()){
			curr=open.get(open.size());
			ArrayList<Node> neighs = curr.makeNeighbors(this.h, this);
			for (Node n : neighs){
				if(open.contains(n))
					open.indexOf(n)
					neighs.remove(n);
				if(closed.contains(n))
					neighs.remove(n);
			}
			open.addAll(neighs);
			for(Node n: neighs){
				
			}
			
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
