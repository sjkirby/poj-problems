import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static int a,b,c,freeCows = 0;
	static ArrayList<HashSet<Integer>> possibles = new ArrayList<HashSet<Integer>>();
	static ArrayList<ArrayList<HashSet<Integer>>> cows = new ArrayList<ArrayList<HashSet<Integer>>>(); 
	
	static void recur(int start, int len, int tot, HashSet<Integer> cur){
		if(len == 0){
//			count++;
//			System.out.println(cur+" "+possibles.size());
			possibles.add(cur);
			return;
		}
		for(int i = start+1;i<=tot-len;i++){
			@SuppressWarnings("unchecked")
			HashSet<Integer> temp = (HashSet<Integer>) cur.clone();
			temp.add(i);
			recur(i,len-1,tot,temp);
		}
		
		
	}
	
	static void build(int len, int tot){
		recur(0,len,tot+1,new HashSet<Integer>());
	}
	
	static boolean valid(HashSet<Integer> cow, HashSet<Integer> diseaseSet){
		for(Integer x: cow){
			if(!diseaseSet.contains(x)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// 
		
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		
		for(int i = 0; i <= a; i++) cows.add(new ArrayList<HashSet<Integer>>());
		
		build(c,b);
		for(int i = 0; i<a;i++){
			int numDiseases = in.nextInt();
			if(numDiseases ==0 )freeCows++;
			else{
				int index = in.nextInt();
				HashSet<Integer> cow = new HashSet<Integer>();
//				cow.add(index);
				for(int j = 1; j < numDiseases;j++){
					cow.add(in.nextInt());
				}
//				System.out.println(""+cow);
				cows.get(index).add(cow);
				
			}
		}
		
		int max = 0;
		for(HashSet<Integer> diseaseSet: possibles){
			int total = 0;
			for(Integer disease: diseaseSet){
				for(HashSet<Integer> cow: cows.get(disease)){
					if(valid(cow,diseaseSet)) total++;
				}
			}
			max = Math.max(total, max);
		}
		
		System.out.println(max+freeCows);
		
		
	}

}