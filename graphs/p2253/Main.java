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

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numPoints = in.nextInt();
		int scenario = 1;
		while(numPoints != 0){
			HashSet<Point> unsolved = new HashSet<Point>();
			HashSet<Point> solved = new HashSet<Point>();
			solved.add(new Point(in.nextInt(),in.nextInt()));
			Point target = new Point(in.nextInt(),in.nextInt());
			unsolved.add(target);
			
			double cost = 0;
			
			for(int i = 2; i < numPoints; i++){
				unsolved.add(new Point(in.nextInt(),in.nextInt()));
			}
			
			while(!solved.contains(target)){
				double minCost = 10000000;
				Point minNode = null;
				for(Point p : unsolved){
					if(minCost <= cost) break;
					for(Point p2 : solved){
						double dist = p.distance(p2);
						if (dist < minCost){
							minCost = dist;
							minNode = p;
							if (minCost < cost){
								break;
							}
						}
						
					}
				}
				solved.add(minNode);
				unsolved.remove(minNode);
				cost = Math.max(minCost, cost);
			}
			
//			cost = Math.round(cost * 1000);
//			System.out.print(""+(cost/1000));
//			System.out.print(".");
			System.out.format("Scenario #%d\nFrog Distance = %.3f\n\n",scenario,cost);
			numPoints = in.nextInt();
			scenario++;
			
			
			
			
		}
	}

}