package p2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void p(String str){
		System.out.println(str);
	}
	
	public static void pr(String str){
		System.out.print(str);
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numnames = in.nextInt();
		
		int set = 0;
		while(numnames != 0){
			set++;
			ArrayList<String> left = new ArrayList<String>();
			ArrayList<String> right = new ArrayList<String>();
			for(int i = 0; i < numnames; i++){
				if(i%2 == 0){
					left.add(in.next());
				}
				else{
					right.add(in.next());
				}
			}
			p("SET "+set);
			Collections.reverse(right);
			for(String s : left){
				p(s);
			}
			for(String s : right){
				p(s);
			}
			
			
			numnames = in.nextInt();
		}
		
	}
}
