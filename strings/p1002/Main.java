package p1002;

import java.util.Scanner;
import java.util.TreeMap;

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
		int numnumbers = in.nextInt();
		
		String oldstr = "0123456789ABCDEFGHIJKLMNOPRSTUVWXY";
		String newstr = "0123456789222333444555666777888999";
		
		char replace[] = new char[256];
		
		for(int i = 0; i < oldstr.length(); i++){
			replace[oldstr.charAt(i)] = newstr.charAt(i);
		}
		
		TreeMap<String,Integer> allnums = new TreeMap<String,Integer>();
		while(numnumbers --> 0){
			String inp = in.next();
			String out = "";
			for(char c : inp.toCharArray()){
				if(c != '-'){
					out += replace[c];
				}
			}
			if(!allnums.containsKey(out)){
				allnums.put(out, 1);
			}
			else{
				allnums.put(out, allnums.get(out) + 1);
			}
		}
		int count = 0;
		for(String s : allnums.keySet()){
			if(allnums.get(s) != 1){
				p(""+s.substring(0, 3)+"-"+s.substring(3, 7)+" "+allnums.get(s));
				count++;
			}
			
				
		}
		if(count == 0){
			p("No duplicates.");
		}
	}

}

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
16
4873279
ITS-EASY
888-4567
3-10-10-10
888-GLOP
TUT-GLOP
967-11-11
310-GINO
F101010
888-1200
-4-8-7-3-2-7-9-
487-3279
ABCDEFG
ABCDEFG
HIJKLMN
HIJKLMN
1
ASDFASD
*/
