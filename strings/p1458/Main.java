import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String a = in.next(), b = in.next();
			ArrayList<Integer> last = new ArrayList<Integer>();
			for(int i = 0; i < a.length();i++){
				last.add(0);
			}
			
			Integer max = 0;
			
			for(int j = 0; j < b.length();j++){
				ArrayList<Integer> newscores = new ArrayList<Integer>();
				int linemax = 0;
				for(int i = 0; i < a.length();i++){
					if(a.charAt(i) == b.charAt(j)){
						if(i == 0){
							newscores.add(linemax + 1);
							max = Math.max(linemax + 1, max);
						}
						else{
							newscores.add(1 + linemax);
							max = Math.max(1 + linemax, max);
						}
						
					}
					else{
						newscores.add(linemax);
					}
					linemax = Math.max(linemax, last.get(i));
				}
				for(int i = 0; i < last.size();i++){
					last.set(i, Math.max(last.get(i), newscores.get(i)));
				}
				
			}
			
			System.out.println(""+max);
			
			
		}
		in.close();
	}

}