import java.awt.Point;
import java.util.ArrayList;
import world.Robot;
public class Node {
	public Point location;
	public double moveScore;
	public double hScore;
	public boolean passable;
	public ArrayList<Node> neighbors;
	public double cost;
	public Node(Point p, double movestodate, double heur){
		location = p;
		moveScore= movestodate;
		hScore=heur;
	}
	public boolean equals(Object obj)
	   {
	      if (obj == null)
	      {
	         return false;
	      }
	      if (getClass() != obj.getClass())
	      {
	         return false;
	      }
	      final Node other = (Node)obj;
	      return other.location==this.location;
	   }
	public double getCost(){
		this.cost=hScore+moveScore;
		return this.cost;
	}
	public ArrayList<Node> makeNeighbors(Heuristic h, Robot r){
		ArrayList<Node> nay = new ArrayList<Node>();
		int x = (int) this.location.getX();
		int y = (int) this.location.getY();
		if (x-1>=0){
			nay.add(new Node(new Point(x-1,y),this.moveScore+1,h.score(new Point(x-1,y), ((VanillaAStar)r).end)));
			if (y-1>0)
				nay.add(new Node(new Point(x-1,y-1),this.moveScore+1,h.score(new Point(x-1,y-1), ((VanillaAStar)r).end)));
			if (y+1<((VanillaAStar)r).height)
				nay.add(new Node(new Point(x-1,y+1),this.moveScore+1,h.score(new Point(x-1,y+1), ((VanillaAStar)r).end)));

		}
		if (x+1<((VanillaAStar)r).width){
			nay.add(new Node(new Point(x+1,y),this.moveScore+1,h.score(new Point(x+1,y), ((VanillaAStar)r).end)));
			if (y-1>0)
				nay.add(new Node(new Point(x+1,y-1),this.moveScore+1,h.score(new Point(x+1,y-1), ((VanillaAStar)r).end)));
			if (y+1<((VanillaAStar)r).height)
				nay.add(new Node(new Point(x+1,y+1),this.moveScore+1,h.score(new Point(x+1,y+1), ((VanillaAStar)r).end)));
		}
		if (y-1>0){
			nay.add(new Node(new Point(x,y-1),this.moveScore,h.score(new Point(x,y-1), ((VanillaAStar)r).end)));
		}
		if (y+1<((VanillaAStar)r).height){
			nay.add(new Node(new Point(x,y+1),this.moveScore,h.score(new Point(x,y+1), ((VanillaAStar)r).end)));
		
		}
		return nay;
	}
}
