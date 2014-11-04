import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int numbits(int a){
		int count = 0;
		for(int i = 0;i<32;i++){
			if(((a>>i)&1) == 1){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
        	int a=cin.nextInt();
        	if(a == 0){
        		break;
        	}
        	int count = numbits(a);
        	for(int i  = a+1;;i++){
        		if(numbits(i) == count){
        			System.out.println(""+i);
        			break;
        		}
        	}

        }
        cin.close();
	}

}