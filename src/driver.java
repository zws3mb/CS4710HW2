import world.*;
import java.awt.Point;
//import world.Robot;
public class driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{	
		World myWorld = new World("testmap.txt",false);
		
		
		VanillaAStar arobot= new VanillaAStar(myWorld);
		}
		catch(Exception e){
			System.out.println("Error"+e.toString());
		}
	}

}
