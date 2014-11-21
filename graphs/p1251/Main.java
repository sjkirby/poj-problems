package p1251;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Edge{
	String to;
	int cost;
	
	Edge(String _to, int _cost){
		to = _to;
		cost = _cost;
	}
	
	public int hashCode(){
		return to.hashCode() >>> 16 | to.hashCode() << 16 ^ cost;
	}
	
	public boolean equals(Object other){
		Edge edge2 = (Edge)other;
		return to == edge2.to && cost == edge2.cost;
	}
	
}

public class Main {
	
	public static void p(String str){
		System.out.println(str);
	}
	
	public static void pr(String str){
		System.out.print(str);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int numcity = in.nextInt();
		while(numcity != 0){
			HashMap<String, HashSet<Edge>> edges = new HashMap<String, HashSet<Edge>>();
			HashSet<String> solved = new HashSet<String>();
			HashSet<String> unsolved = new HashSet<String>();
			unsolved.add(""+(char)('A'+numcity-1));
			for(int i = 1; i < numcity; i++){
				String cityname = in.next();
				int numconnections = in.nextInt();
				if(i == 1){
					solved.add(cityname);
				}
				else unsolved.add(cityname);
				for(int j = 0; j < numconnections; j++){
					String tocityname = in.next();
					int cost = in.nextInt();
//					unsolved.add(tocityname);
					if(!edges.containsKey(cityname)) edges.put(cityname, new HashSet<Edge>());
					if(!edges.containsKey(tocityname)) edges.put(tocityname, new HashSet<Edge>());
					edges.get(cityname).add(new Edge(tocityname,cost));
					edges.get(tocityname).add(new Edge(cityname,cost));
				}
			}
			
			int cost = 0;
			while(!unsolved.isEmpty()){
				int minCost = 2000000000;
				String minNode = null;
				
				for(Iterator<String> sit = solved.iterator(); sit.hasNext();){
					String s = sit.next();
//					p(""+s);
//					p(""+edges.get(s));
					if(edges.get(s).size() == 0){
						sit.remove();
						continue;
					}
					for (Iterator<Edge> setit = edges.get(s).iterator(); setit.hasNext();) {
					    Edge element = setit.next();
					    if(solved.contains(element.to)) {
					    	setit.remove();
					    	continue;
					    }
					    if(element.cost < minCost){
					    	minNode = element.to;
					    	minCost = element.cost;
					    }
					    
					}
				}
				cost += minCost;
				unsolved.remove(minNode);
				solved.add(minNode);
				
			}
			p(""+cost);
			
			numcity = in.nextInt();
		}
		
		in.close();
	}

}
/*
9
A 2 B 12 I 25
B 3 C 10 H 40 I 8
C 2 D 18 G 55
D 1 E 44
E 2 F 60 G 38
F 0
G 1 H 35
H 1 I 35
3
A 2 B 10 C 40
B 1 C 20
0
*/