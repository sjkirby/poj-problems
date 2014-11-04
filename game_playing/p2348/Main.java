import java.util.Scanner;
public class Main {
	
	static boolean branch(int x, int y){
		if (y < x) return branch(y,x);
		if (y % x == 0) return true;
		if (x < (y - x)) return !branch(y%x,x) || !branch((y%x)+x,x);
		return !branch(y%x,x);
	}
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int a, b;
		a = in.nextInt();
		b = in.nextInt();
		while(a!=0&&b!=0){
			if(branch (a,b)) System.out.println("Stan wins");
			else System.out.println("Ollie wins");

			a = in.nextInt();
			b = in.nextInt();
		}
		
		
	}
}