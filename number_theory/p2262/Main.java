package p2262;

import java.util.Scanner;
import java.util.TreeSet;

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
		char primes[] = new char[1000000];
		TreeSet<Integer> sortedprimes = new TreeSet<Integer>();
		for(int i = 2; i < 1000000; i++){
			if(primes[i] == 1) continue;
			sortedprimes.add(i);
			for(int mark = i + i; mark < 1000000; mark+=i){
				primes[mark] = 1;
			}
		}
		int test = in.nextInt();
		while(test != 0){
			for(Integer i : sortedprimes.descendingSet().subSet(test, 2)){
				if(sortedprimes.contains(test - i)){
					p(""+test+" = "+(test-i)+" + "+i);
					break;
				}
			}
			
			test = in.nextInt();
		}
		in.close();
	}

}
