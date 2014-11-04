import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	static TreeMap<Integer,Integer> dp;
	
	static int a,b;
	
	static int maxBetween(int start){
		int max = -1000000;
		for(int i: dp.subMap(start+a, start+b+1).keySet()){
			if(dp.get(i) > max) max = dp.get(i);
		}
		if (max == -1000000) max = 0;
		return max;
	}
	
	static int solve(){
		for(int i: dp.descendingKeySet()){
			dp.put(i, i - maxBetween(i));
		}
		return maxBetween(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		
		
		int t = in.nextInt();
		while (t-- != 0){
			dp = new TreeMap<Integer,Integer>();
			int n;
			n = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			while(n-- != 0){
				int num = in.nextInt();
				if(num > 0){
					dp.put(num, 0);
				}
			}
			System.out.println(""+solve());
			
		}
		in.close();
		
	}

}