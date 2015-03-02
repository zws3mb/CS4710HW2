import java.awt.Point;
	public class Manhattan implements Heuristic{
		public Manhattan(){
			super();
		}
		public double score(Point cur, Point in){
			return (double)Math.abs(cur.getX()-in.getX())+Math.abs(cur.getY()-in.getY());
		}
	}