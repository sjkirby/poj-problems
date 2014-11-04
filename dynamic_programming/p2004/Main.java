import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner cin=new Scanner(System.in);
        List<List<String>> lens = new ArrayList<List<String>>(20);
        for(int i = 0; i<20; i++){lens.add(new ArrayList<String>());}
        Hashtable<String,Integer> combos = new Hashtable<String,Integer>();
        Hashtable<String,String> paths = new Hashtable<String,String>();
        Hashtable<String,String> converts = new Hashtable<String,String>();
        
        while(cin.hasNext())
        {
        	String a=cin.next();
        	if(a.equals("1")){
        		break;
        	}
        	char[] chars = a.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            combos.put(sorted, 1);
            lens.get(sorted.length()-1).add(sorted);
            converts.put(sorted, a);

        }
        cin.close();
        for(int l = 19;l>=0;l--){
        	for (String s: lens.get(l)){
        		int value = combos.get(s);
        		for (int i = 0; i<s.length();i++){
        			String newStr = s.substring(0, i)+s.substring(i+1);
        			if (combos.containsKey(newStr) && combos.get(newStr) < value +1){
        				combos.put(newStr, value + 1);
        				paths.put(newStr, s);
        			}
        		}        		
        	}
        }
        int ma = 0;
        String best = "";
        for(List<String> x: lens){
        	for (String s: x){
        		if(combos.get(s) > ma){
        			ma = combos.get(s);
        			best = s;
        		}
        	}
        }
        System.out.println(converts.get(best));
        while(paths.containsKey(best)){
        	best = paths.get(best);
        	System.out.println(converts.get(best));
        }
	}

}