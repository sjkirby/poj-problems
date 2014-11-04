import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int len;
	static int[] order = new int[1000];
	static int[] cyclen = new int[1000];
	
	public static int gcd(int p, int q){
		if(q == 0 || p == 0){
			return p+q;
		}
		return gcd(q,p%q);
	}
	
	public static int lcm(int p, int q){
		return p * (q / gcd(p,q)) ;
	}
	
	public static int cycleLen(int start){
		//int count = 1;
		int step = order[start-1];
		int count;
		for(count = 1;step != start;count++) step = order[step-1];
		return count;
	}
	
	public static int calc(){
		int out = 1;
		for(int i = 0;i<len;i++){
			out = lcm(cyclen[i],out);
		}
		return out;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
        len = cin.nextInt();
        for(int i = 0; i< len; i++){
        	order[i] = cin.nextInt();
        }
        cin.close();
        for(int i = 0;i<len;i++){
        	cyclen[i] = cycleLen(order[i]);
        }
        System.out.println(""+calc());
	}

}