package add_Digits;

import java.util.Scanner;

public class Add_Digits {
	
	public static int addDigits(int num) {
	        
			//https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
			return 1 + (num - 1) % 9;
			
	    }

	public static int addDigits_recursive(int num) {
		
		int sum = 0;
		
		if (num < 10) {
			return num;
		} else {
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			return addDigits_recursive(sum);
		}
		
	}
	
	public static void main(String[] args) {
    	System.out.println("Input an integer: ");
    	Scanner scan = new Scanner(System.in);
    	String s = scan.nextLine();
    	System.out.println("The digital root = " + addDigits(Integer.parseInt(s)));
    	scan.close();
	}
	
}
