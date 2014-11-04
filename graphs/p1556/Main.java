import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;



class Point{
	int x;
	int y;
	
	Point(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	double distance(Point p2){
		return Math.pow(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2), .5); 
	}
	
}

class Door{
	int x;
	int y1;
	int y2;
	int y3;
	int y4;
	
	Door(double _x, double _y1, double _y2, double _y3, double _y4){
		x = (int)Math.round(_x * 2);
		y1 = (int)Math.round(_y1 * 2);
		y2 = (int)Math.round(_y2 * 2);
		y3 = (int)Math.round(_y3 * 2);
		y4 = (int)Math.round(_y4 * 2);
	}
	
	boolean canPass(Point p, double slope){
		double intersect = p.y + (slope * (x - p.x));
//		System.out.println(""+intersect);
		if(intersect >= y1 && intersect <= y2) return true;
		if(intersect >= y3 && intersect <= y4) return true;
		
		return false;
	}
	
}


public class Main {
	
	static ArrayList<Door> Doors;
	
	static boolean canReach(Point p1, Point p2){
		if (p1.x >= p2.x) return false;
		
		double slope = (p2.y - p1.y) / (double)(p2.x - p1.x);
		
		for(int i = p1.x + 1;i<p2.x;i++){
			Door tempDoor = Doors.get(i);
			if(tempDoor == null) continue;
			if(! tempDoor.canPass(p1, slope)) return false;
		}
		
		
		return true;
	}
	
	static double cost(Point p1,Point p2){
		if(canReach(p1,p2)) return p1.distance(p2);
		return 10000000;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		Door tempDoor1 = new Door(1,2,3,4,5);
//		Point p11 = new Point(0,0);
//		Point p21 = new Point(2,5);
//		
//		double slope = (p21.y - p11.y) / (double)(p21.x - p11.x);
//		System.out.println(""+slope);
//		System.out.println(""+tempDoor1.canPass(p11, slope));
		
		
		int numDoors = in.nextInt();
		
		
		while(numDoors != -1){
			Doors = new ArrayList<Door>();
			for(int i = 0; i < 20;i++){
				Doors.add(null);
			}
			
			HashMap<Point,Double> solved = new HashMap<Point,Double>();
			HashSet<Point> unsolved = new HashSet<Point>();
			Point target = new Point(20,10); 
			
			solved.put(new Point(0,10),0.0);
			
			unsolved.add(target);
			
			for(int i = 0; i < numDoors; i++){
				Door tempDoor = new Door(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble());
				Doors.set(tempDoor.x, tempDoor);
				unsolved.add(new Point(tempDoor.x,tempDoor.y1));
				unsolved.add(new Point(tempDoor.x,tempDoor.y2));
				unsolved.add(new Point(tempDoor.x,tempDoor.y3));
				unsolved.add(new Point(tempDoor.x,tempDoor.y4));
			}
			
			
			while(!solved.containsKey(target)){
				double bestCost = 10000000;
				Point bestPoint = null;
				for (Point p1 : solved.keySet()){
					double curCost = solved.get(p1);
					for (Point p2 : unsolved){
//						System.out.print(""+p1.x+" "+p1.y);
//						System.out.print(" -> "+p2.x+" "+p2.y);
//						System.out.println(" : "+canReach(p1,p2));
						double newCost = curCost + cost(p1,p2);
						if(newCost < bestCost){
							bestCost = newCost;
							bestPoint = p2;
							
							
							
//							System.out.print(" : "+cost(p1,p2));
//							System.out.println(" : "+curCost);
						}
					}
				}
				solved.put(bestPoint, bestCost);
				unsolved.remove(bestPoint);
			}
//			System.out.println(""+solved.get(target));
//			System.out.println();
//			System.out.println();
//			System.out.println();
			
//			for(Point p : solved.keySet()){
//				System.out.print(""+p.x+" "+p.y);
//				System.out.println(": "+solved.get(p));
//			}
			
			Point tp1 = new Point(0,10);
			Point tp2 = new Point(14,9);
			Point tp3 = new Point(20,10);
			
			
			
//			System.out.println(""+tp1.distance(tp2));
//			System.out.println(""+tp2.distance(tp3));
			
			System.out.format("%.2f\n",solved.get(target) / 2.0);
			
			numDoors = in.nextInt();
		}
		in.close();

	}

}